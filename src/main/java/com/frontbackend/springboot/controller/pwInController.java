package com.frontbackend.springboot.controller;

import com.frontbackend.springboot.model.*;
import com.frontbackend.springboot.service.CredsService;
import com.frontbackend.springboot.service.MessageService;
import com.frontbackend.springboot.service.PasswordService;
import com.frontbackend.springboot.service.pwInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/pwIn")
public class pwInController {


    @PostMapping(
            value = "/logIn", consumes = "application/json")
    public <T> T createPerson(@RequestBody pwIn pwin) throws JSONException {
        pwIn input = pwInService.saveUpdatePerson(pwin);
        String username = input.getUsername();
        String password = input.getPassword();
        List <Password> credentials = PasswordService.findByGroupname(username);
        if (credentials.isEmpty()) {
            Message m = new Message("This user does not exist");
            return (T) MessageService.saveUpdateMessage(m);
        } else {
            String dbPw = credentials.get(0).getPw();
            if (password.equals(dbPw)) {
                Creds c = new Creds(credentials.get(0).getGroupid(), credentials.get(0).getGroupname());
                return (T) CredsService.saveUpdateCreds(c);
            } else {
                Message m = new Message("Wrong password, please try again");
                return (T) MessageService.saveUpdateMessage(m);
            }
        }
    }



}
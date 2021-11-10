package com.frontbackend.springboot.controller;

import com.frontbackend.springboot.model.Password;
import com.frontbackend.springboot.model.PasswordRequest;
import com.frontbackend.springboot.model.pwIn;
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
            value = "/logIn", consumes = "application/json", produces = "application/json")
    public String createPerson(@RequestBody pwIn pwin) throws JSONException {
        pwIn input = pwInService.saveUpdatePerson(pwin);
        String username = input.getUsername();
        String password = input.getPassword();
        List <Password> credentials = PasswordService.findByGroupname(username);
        if (credentials.isEmpty()) {
            String content = "message: This username does not exist";
            return content;
        } else {
            String dbPw = credentials.get(0).getPw();
            if (password.equals(dbPw)) {
                String content = "groupid: "+credentials.get(0).getGroupid()+",groupname: " + credentials.get(0).getGroupname();
                return content;
            } else {
                return "message: Wrong password, please try again";
            }
        }
    }



}
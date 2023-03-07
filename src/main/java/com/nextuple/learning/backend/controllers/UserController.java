package com.nextuple.learning.backend.controllers;

import com.nextuple.learning.backend.handlers.NoUserNameFoundException;
import com.nextuple.learning.backend.models.LoginUser;
import com.nextuple.learning.backend.models.Recharge;
import com.nextuple.learning.backend.models.User;
import com.nextuple.learning.backend.services.RechargeService;
import com.nextuple.learning.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value="/users", consumes = {"application/json"})
    public ResponseEntity<String> saveUser(@RequestBody User user) throws Exception {
        return new ResponseEntity<String>(userService.addNewUser(user), HttpStatus.OK);
    }
    @CrossOrigin(origins="http://localhost:3000")
    @PostMapping(value="/userlogin", consumes = {"application/json"})
    public ResponseEntity<String> verifyUser(@RequestBody LoginUser loginCred) throws Exception {
        return new ResponseEntity<String>(userService.loginVerification(loginCred),HttpStatus.OK);
    }
}

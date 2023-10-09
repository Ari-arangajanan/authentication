package com.ari.AuthenticationAuthorization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String home(){
        return "<h1>Home</h1>";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String user(){
        return "<h1>Home user</h1>";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(){
        return "<h1>Home admin</h1>";
    }
}

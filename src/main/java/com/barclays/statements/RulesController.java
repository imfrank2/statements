package com.barclays.statements;

import com.barclays.statements.Models.Rules;
import com.barclays.statements.Repositories.RulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RulesController {

    @Autowired
    private RulesRepository repository;


    @RequestMapping("/welcome/user")
    public String welcomeUser(@RequestParam(name="name", required=false, defaultValue="Java Fan") String name) {
        return "Hello There "+name;
    }

    @RequestMapping(value ="/getRules", method = RequestMethod.GET)
    public List<Rules> getRules(){
        return this.repository.findAll();
    }

    @RequestMapping(value ="/addRule", method = RequestMethod.POST)
    public void addRule(@RequestParam(name="rule") String rule){
        this.repository.insert(new Rules(new ObjectId(), rule));
    }

}

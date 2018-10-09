package com.barclays.statements;

import com.barclays.statements.Models.Rules;
import com.barclays.statements.Repositories.RulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/getRule/{id}", method = RequestMethod.GET)
    public Optional<Rules> getRule(@PathVariable String id){
        return this.repository.findById(id);
    }

    @RequestMapping(value = "/deleteRule/{id}", method = RequestMethod.DELETE)
    public void deleteRule(@PathVariable String id){
        this.repository.deleteById(id);
    }

}

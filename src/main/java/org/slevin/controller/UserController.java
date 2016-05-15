package org.slevin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.slevin.common.User;
import org.slevin.dao.UsersDao;
 
@RestController
@RequestMapping("/users")
public class UserController {
 
	@Autowired
	UsersDao userService;  //Service which will do all data retrieval/manipulation work
 
        
     
    //-------------------Create a SocialUser--------------------------------------------------------
     
    @RequestMapping(value = "/newuser", method = RequestMethod.POST)
    public User createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) throws Exception {
        System.out.println("Creating User " + user.getEmail());
 
        /*if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
        
        user.setSecret(new BigInteger(64, new SecureRandom()).toString(16)); 
        //il controllo di creazione e login viene fatto front end; creo in rms il socialuser con la sua secret-key
        userService.persist(user);

 
        /*HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getUid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);*/
        return userService.findByProperty("email", "m.procopio91@gmail.com").get(0);
        
    }
 
     
   
 
}



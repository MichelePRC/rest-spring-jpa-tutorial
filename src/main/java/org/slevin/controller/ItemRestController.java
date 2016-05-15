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
 
import org.slevin.common.Item;
import org.slevin.dao.ItemsDao;
 
@RestController
@RequestMapping("/restitems")
public class ItemRestController {
 
	@Autowired
	ItemsDao itemService;  //Service which will do all data retrieval/manipulation work
 
        
     
    //-------------------Create a RItem--------------------------------------------------------
     
    @RequestMapping(value = "/newritem", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody Item ritem,    UriComponentsBuilder ucBuilder) throws Exception {
        System.out.println("Creating Ritem " + ritem.getProduct());
 
        /*if (userService.isUserExist(user)) {
            System.out.println("A User with name " + user.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }*/
 
        itemService.persist(ritem);

 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/ritem/{id}").buildAndExpand(ritem.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
     
   
 
}


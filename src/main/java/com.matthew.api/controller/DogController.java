package com.matthew.api.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matthew.api.model.Dog;

@RestController
public class DogController {
   
   private static Map<String, Dog> dogCollection = new HashMap<>();
   static {
      Dog george = new Dog(1, "George", "Golden Retriever", 1, "Blonde");
      dogCollection.put(george.getId(), george);

      Dog theodore = new Dog(2, "Theodore", "Poodle", 2, "Yellow");
      dogCollection.put(theodore.getId(), theodore);

   }
   
   @RequestMapping(value = "/dogs", method = RequestMethod.GET)
   public ResponseEntity<Object> getDog() {
      return new ResponseEntity<>(dogCollection.values(), HttpStatus.OK);
   }

   @RequestMapping(value = "/dogs", method = RequestMethod.POST)
   public ResponseEntity<Object> createDog(@RequestBody Dog doggie) {
      // NOTE: For this to work, must include request header Content-Type=application/json
      dogCollection.put(doggie.getId(), doggie);
      return new ResponseEntity<>("The doggie has been added!", HttpStatus.CREATED);
   }
   
   @RequestMapping(value = "/dogs/{id}/{age}", method = RequestMethod.PUT)
   public ResponseEntity<Object> updateDog(@PathVariable("id") int id, @PathVariable("age") int age /*, @RequestBody Dog doggie*/) { 
      Dog thisDog = dogCollection.get(Integer.toString(id)); // Find the dog saved using id, cache into memory
      dogCollection.remove(thisDog.getId()); // Wipe out the old record
      thisDog.setAge(age); // Update the record cached in memory
      dogCollection.put(thisDog.getId(), thisDog); // Put the updated record back into the collection
      return new ResponseEntity<>("Doggie is updated successsfully", HttpStatus.OK);
   }

   @RequestMapping(value = "/dogs/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<Object> deleteDog(@PathVariable("id") int id) { 
      dogCollection.remove(Integer.toString(id));
      return new ResponseEntity<>("Doggie is deleted successsfully", HttpStatus.OK);
   }

   // @RequestMapping(value = "/parrot/{phrase}", method = RequestMethod.GET)
   // public ResponseEntity<Object> repeatBack(@PathVariable("phrase") String phrase, Product product) {
   //    return new ResponseEntity<>(product.parrotBack(phrase), HttpStatus.OK);
   // }

}
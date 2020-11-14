package com.matthew.myproject.model;

public class Product {
   private String id;
   private String name;
   private String phrase;

   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }

   public String parrotBack(String phrase) {
      String fullPhrase = phrase + "_squawk";
      return fullPhrase;
   }
}
package com.pankaj.springbootkafkaproducer.controller;

import com.pankaj.springbootkafkaproducer.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    @GetMapping("/products/{name}")
    public String getProduct(@PathVariable String name){
         LOGGER.info("ProductController- Method Started.", name);

         kafkaTemplate.send("products", name);
         return "data publish";

    }
    @GetMapping("/products")
    public String publishObject(){
        LOGGER.info("ProductController- Method publishObject.");
        Product product = new Product(123L,"BMW","BMW 7 series");
        kafkaTemplate.send("products", product);
        return  "Object published";
    }
}

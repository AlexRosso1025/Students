package co.com.poli.finalcloudaq.finalcloudaq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping("/status")
    public String status(){
        return "This is Working";
    }
}
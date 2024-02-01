package com.mrogotnev.demo.controllers;

import com.mrogotnev.demo.entity.FullStringFromJson;
import com.mrogotnev.demo.exceptions.InvalidDataFromJsonException;
import com.mrogotnev.demo.services.CharCalculatorServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedHashMap;

@RestController
@AllArgsConstructor
public class MainController {
    private CharCalculatorServiceInterface charCalculatorService;

    @PostMapping(value = "/getCountFromFullStringWithDescendingOrder", consumes = {"application/json"})
    public LinkedHashMap<Character, Integer> getCountFromFullStringWithDescendingOrder(@RequestBody FullStringFromJson fullString) {
        try {
            return charCalculatorService.calculatingCharCountWithDescendingOrder(fullString.getData());
        } catch (InvalidDataFromJsonException exception) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Json data is null", exception
            );
        }


    }
}

package com.mrogotnev.demo.services;

import com.mrogotnev.demo.exceptions.InvalidDataFromJsonException;

import java.util.LinkedHashMap;

public interface CharCalculatorServiceInterface {
    public LinkedHashMap<Character, Integer> calculatingCharCountWithDescendingOrder(String fullString) throws InvalidDataFromJsonException;
}

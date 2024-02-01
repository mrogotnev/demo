package com.mrogotnev.demo.services;

import com.mrogotnev.demo.exceptions.InvalidDataFromJsonException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CharCalculatorService implements CharCalculatorServiceInterface {
    public LinkedHashMap<Character, Integer> calculatingCharCountWithDescendingOrder(String fullString) throws InvalidDataFromJsonException{
        return sortMapByValueDescending(calculatingCharCount(fullString));
    }

    private HashMap<Character, Integer> calculatingCharCount(String fullString) throws InvalidDataFromJsonException {
        HashMap<Character, Integer> table = new HashMap<>();
        if (fullString == null) {
            throw new InvalidDataFromJsonException("Json data is null");
        }
        for (Character currentCha : fullString.toCharArray()) {
            if (table.containsKey(currentCha)) {
                int countFromTable = table.get(currentCha);
                table.put(currentCha, countFromTable + 1);
            } else {
                table.put(currentCha, 1);
            }
        }
        return table;
    }

    private LinkedHashMap<Character, Integer> sortMapByValueDescending(HashMap<Character, Integer> table) {
        return table.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, LinkedHashMap::new));
    }
}

package com.mrogotnev.demo.servicesTests;

import com.mrogotnev.demo.exceptions.InvalidDataFromJsonException;
import com.mrogotnev.demo.services.CharCalculatorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharCalculatorServiceTests {
    CharCalculatorService charCalculatorService = new CharCalculatorService();
    HashMap<Character, Integer> resultTableWithAllChar = new HashMap<>();
    HashMap<Character, Integer> emptyTable = new HashMap<>();
    HashMap<Character, Integer> resultTableForSorting = new HashMap<>();
    LinkedHashMap<Character, Integer> sortedResultTable = new LinkedHashMap<>();

    @Before
    public void init(){
        resultTableWithAllChar.put('a', 2);
        resultTableWithAllChar.put('A', 1);
        resultTableWithAllChar.put('b', 1);
        resultTableWithAllChar.put('B', 2);
        resultTableWithAllChar.put('\\', 1);
        resultTableWithAllChar.put('\n', 1);
        resultTableWithAllChar.put(' ', 1);
        resultTableWithAllChar.put('`', 1);
        resultTableWithAllChar.put('~', 1);
        resultTableWithAllChar.put('!', 1);
        resultTableWithAllChar.put('@', 1);
        resultTableWithAllChar.put('#', 1);
        resultTableWithAllChar.put('$', 1);
        resultTableWithAllChar.put('%', 1);
        resultTableWithAllChar.put('^', 1);
        resultTableWithAllChar.put('&', 1);
        resultTableWithAllChar.put('*', 1);
        resultTableWithAllChar.put('(', 1);
        resultTableWithAllChar.put(')', 1);
        resultTableWithAllChar.put('-', 1);
        resultTableWithAllChar.put('_', 1);
        resultTableWithAllChar.put('=', 1);
        resultTableWithAllChar.put('+', 1);
        resultTableWithAllChar.put('?', 1);
        resultTableWithAllChar.put('.', 1);
        resultTableWithAllChar.put(',', 1);
        resultTableWithAllChar.put('<', 1);
        resultTableWithAllChar.put('>', 1);

        resultTableForSorting.put('a', 1);
        resultTableForSorting.put('c', 2);
        resultTableForSorting.put('d', 3);
        resultTableForSorting.put('e', 4);
        resultTableForSorting.put('f', 5);

        sortedResultTable.put('f', 5);
        sortedResultTable.put('e', 4);
        sortedResultTable.put('d', 3);
        sortedResultTable.put('c', 2);
        sortedResultTable.put('a', 1);

    }
    @Test
    public void calculatingCharCountTest_WithSpecSymbols() throws InvalidDataFromJsonException {
        String fullString = "aAaBbB~`!@#$%^&*()_-+=?.,<>\\\n ";
        Map<Character, Integer> result = charCalculatorService.calculatingCharCountWithDescendingOrder(fullString);
        Assert.assertEquals(result, resultTableWithAllChar);
    }

    @Test
    public void calculatingCharCountTest_WithEmptyString() throws InvalidDataFromJsonException {
        String fullString = "";
        Map<Character, Integer> result = charCalculatorService.calculatingCharCountWithDescendingOrder(fullString);
        Assert.assertEquals(result, emptyTable);
    }

    @Test
    public void sortMapByValueDescendingTest() throws InvalidDataFromJsonException {
        String fullString = "efdeefdfcdcfafe";
        LinkedHashMap<Character, Integer> result = charCalculatorService.calculatingCharCountWithDescendingOrder(fullString);
        Assert.assertEquals(result, sortedResultTable);
    }

    @Test
    public void calculatingCharCountTest_NullString_MustBeException() {
        String fullString = null;

        InvalidDataFromJsonException invalidDataFromJsonException = assertThrows(InvalidDataFromJsonException.class, () -> {
            LinkedHashMap<Character, Integer> result = charCalculatorService.calculatingCharCountWithDescendingOrder(fullString);
                });

        Assert.assertEquals("Json data is null", invalidDataFromJsonException.getMessage());
    }
}

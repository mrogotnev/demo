package com.mrogotnev.demo.controllersTests;

import com.mrogotnev.demo.controllers.MainController;
import com.mrogotnev.demo.services.CharCalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedHashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTests {
    @Autowired
    MockMvc mvc;
    @Autowired
    MainController mainController;
    @Mock
    CharCalculatorService charCalculatorService;
    LinkedHashMap<Character, Integer> sortedResultTable = new LinkedHashMap<>();

    @Before
    public void init() {
        sortedResultTable.put('f', 5);
        sortedResultTable.put('e', 4);
        sortedResultTable.put('d', 3);
        sortedResultTable.put('c', 2);
        sortedResultTable.put('a', 1);
    }


    @Test
    public void mainControllerIsNotNull() {
        assertThat(mainController).isNotNull();
    }

    @Test
    public void getCountFromFullString() throws Exception {
        String inputData = "efdeefdfcdcfafe";
        Mockito.when(this.charCalculatorService.calculatingCharCountWithDescendingOrder(inputData))
                .thenReturn(sortedResultTable);

        mvc.perform(post("/getCountFromFullStringWithDescendingOrder")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content("{\n" +
                                "    \"data\": \"efdeefdfcdcfafe\"\n" +
                                "}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"f\":5,\"e\":4,\"d\":3,\"c\":2,\"a\":1}"));


    }
}

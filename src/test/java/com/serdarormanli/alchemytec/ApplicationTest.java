package com.serdarormanli.alchemytec;

import com.serdarormanli.alchemytec.model.ExpenseData;
import com.serdarormanli.alchemytec.repository.ExpenseRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ApplicationTest {

    @Autowired
    ExpenseRepository repository;

    ExpenseData expenseData;

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() {
        repository.deleteAll();

        expenseData = new ExpenseData(new Date(), "my reason", new BigDecimal(120), null);
    }

    @Test
    public void testInsertAndVat() {
        RestTemplate rest = new TestRestTemplate();

        ResponseEntity<ExpenseData> response =
                rest.postForEntity("http://localhost:" + port + "/expenses", expenseData, ExpenseData.class, Collections.EMPTY_MAP);

        assertEquals(response.getBody().getVat(), new BigDecimal(20));
    }

    @Test
    public void testGetAll() {
        repository.save(expenseData.convertToExpense());

        RestTemplate rest = new TestRestTemplate();

        ResponseEntity<List> response =
                rest.getForEntity("http://localhost:" + port + "/expenses", List.class);

        assertTrue(response.getBody().size() > 0);
    }
}

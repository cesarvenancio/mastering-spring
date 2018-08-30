package com.mastering.spring.boot.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mastering.spring.boot.controller.BasicController;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/features")
@WebMvcTest(BasicController.class)
public class BasicControllerTest {

    @Autowired
    private MockMvc mvc;
    
//    @When("^the client calls /welcome$")
//    public void callWelcome() {
//        mvc.perform(
//                MockMvcRequestBuilders.get("/welcome")
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(content().string(
//                equalTo("Hello World")));
//    }
}

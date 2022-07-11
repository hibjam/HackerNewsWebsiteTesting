package com.sparta.jh.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//junit made of three parts - API, parameterised testing and engine

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.sparta.jh.cucumber.stepdefs", // code that binds the java code and feature code
       // tags = "mvp",
        plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport/json"},
        publish = true
)
public class TestRunner {}

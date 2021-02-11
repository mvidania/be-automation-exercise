package com.mvidania.baautomation.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/petdemo",
        plugin = {"pretty"},
        glue = {"com.mvidania.baautomation.gherkinsteps.petdemo"})
public class GetAvailablePetsTest {

}

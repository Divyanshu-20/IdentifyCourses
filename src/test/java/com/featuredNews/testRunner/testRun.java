package com.featuredNews.testRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(features= {".//Features/"},						//providing location of feature file in "features"
glue="com.featuredNews.stepDefinitions"								//specifying stepDefinition package name
,plugin = { "pretty",												//plugins to generate cucumber report
		"html:reports/myreport.html", 								//for cucumber report
		"rerun:target/rerun.txt",									//capturing failure scenarios
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },     //Generating extent reports
dryRun = false, 													//checks mapping between scenario steps and step definition methods
monochrome = true)													//To avoid junk characters in output
public class testRun extends AbstractTestNGCucumberTests {

}

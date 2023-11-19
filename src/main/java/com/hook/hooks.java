package com.hook;

import com.base.BaseClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class hooks extends BaseClass {

  //every test scenario execution before this method is executed

  //just like @beforeMethod
  @BeforeEach
  public void beforeScenario(Scenario scenario) {
    launchDriver();
    log.info("Scenario Executing Start :-" + scenario.getName());
  }

  //just like @afterMethod
  @After
  public void afterScenario(Scenario scenario) {
    //validate if scenario has failed

    log.info("Scenario Executing Finish :-" + scenario.getName());
    tearDown();
  }
}

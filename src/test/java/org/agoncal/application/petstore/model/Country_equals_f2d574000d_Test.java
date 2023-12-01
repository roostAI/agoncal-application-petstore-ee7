/*
Test Scenario 1: Equal Objects  
Given two objects of type `Country` with the same `isoCode`, calling `equals` on the first with the second as an argument should return `true`.

Test Scenario 2: Unequal Objects  
Given two objects of type `Country` with different `isoCode`, calling `equals` on the first with the second as an argument should return `false`.

Test Scenario 3: Same Object  
Given one object of type `Country`, calling `equals` on itself should return `true`.

Test Scenario 4: Object-null  
Given one object of type `Country`, calling `equals` with `null` as an argument should return `false`.

Test Scenario 5: Different Object Types 
Given one object of another type (not `Country`), calling `equals` should return `false`.

Test Scenario 6: Object-null ISO Code  
Given two objects of type `Country`, where one is having `null` as `isoCode`, calling `equals` on the first with the second as an argument should return `false`.

Test Scenario 7: Both Objects have null ISO Code  
Given two objects of type `Country`, where both are having `null` as `isoCode`, calling `equals` on the first with the second as an argument should return `true`.
*/
package org.agoncal.application.petstore.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountryTest {

  @Test
  public void testEqualObjects() {
      Country country1 = new Country();
      country1.setIsoCode("isoCode1");
      country1.setName("name");
      country1.setPrintableName("printableName");
      country1.setIso3("iso3");
      country1.setNumcode("numCode");

      Country country2 = new Country();
      country2.setIsoCode("isoCode1");
      country2.setName("name");
      country2.setPrintableName("printableName");
      country2.setIso3("iso3");
      country2.setNumcode("numCode");

      assertTrue(country1.equals(country2));
  }
  //Repeat this pattern for other test methods
}

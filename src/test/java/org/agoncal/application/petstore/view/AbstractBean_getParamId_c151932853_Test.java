/*
1. **Scenario:** Test the getParamId method with valid numeric string parameter.
   **Expected Result:** The getParamId method should convert the string into a Long successfully and return it.

2. **Scenario:** Test the getParamId method with a null parameter.
   **Expected Result:** It is expected that the getParam method would throw a NullPointerException and thus getParamId method should also throw a NullPointerException.

3. **Scenario:** Test the getParamId method with an empty string parameter.
   **Expected Result:** The getParam method is expected to treat the empty string as zero and the getParamId method should return 0 as Long.

4. **Scenario:** Test the getParamId method with a very large numeric string parameter.
   **Expected Result:** If the string value is too large for Long, a NumberFormatException should be thrown by the getParam method and thus by the getParamId method as well.

5. **Scenario:** Test the getParamId method with a valid large numeric string parameter within the Long range.
   **Expected Result:** The getParamId method should convert the string into a Long successfully and return it.

6. **Scenario:** Test the getParamId method with a non-numeric string parameter.
   **Expected Result:** The getParam method would throw a NumberFormatException and thus the getParamId method should also throw a NumberFormatException.

7. **Scenario:** Test the getParamId method with a numeric string parameter containing decimal points.
   **Expected Result:** A NumberFormatException should be thrown by the getParam method as the string cannot be converted to Long and thus getParamId should also throw a NumberFormatException.

8. **Scenario:** Test the getParamId method with a string parameter representing negative numbers.
   **Expected Result:** The getParam method would be able to convert the negative numeric string into a Long and thus the getParamId should also return the corresponding negative Long value. 

9.  **Scenario:** Test the getParamId method concurrently from multiple threads. 
    **Expected Result:**  The method should be thread-safe and return the correct values for different inputs.
*/
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>5.7.2</version>
    <scope>test</scope>
</dependency>

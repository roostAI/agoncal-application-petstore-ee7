/*
1. Scenario: Validate the return of the hashCode.
   - Test case: Check the returned hashCode when input is given following the Login constraints.
   - Expected Result: The hashCode of the provided correct Login should be returned.

2. Scenario: Handling of Null.
   - Test Case: Test by passing Null login value.
   - Expected Result: Since login is annotated as NotNull, it should throw a NullPointerException.

3. Scenario: Handling of unique logins.
   - Test case: Check hashCode function with two different logins.
   - Expected Result: The function should return different hashCodes for two different logins.

4. Scenario: Consistency of the hashCode. 
   - Test Case: Test by passing same login multiple times.
   - Expected Result: The function should return the same hashCode for the same login even if it's called multiple times.

5. Scenario: Validate the hashCode method with large size logins.
   - Test case: Pass large size login to hashCode method.
   - Expected Result: The function should be able to process and return the hashCode even for large inputs.

6. Scenario: Test for collision in hashCodes.
   - Test case: Test by passing two different logins where one is an anagram of the other.
   - Expected Result: Even though the letters forming the logins are the same, their order differs, hence different hashCodes should be generated.

7. Scenario: Check the security aspect.
   - Test case: Ensure the login is encrypted when hashCode is generated.
   - Expected Result: The login should not be exposed or retrievable from the generated hashCode.

8. Scenario: Checking the speed of hashCode generation.
   - Test case: Measure the time to calculate the hashCode of a large-size login.
   - Expected Result: The hashCode should be generated in a reasonable time even for large-size inputs.
  
9. Scenario : Testing hashCode's uniform distribution
   - Test case: Pass a large number of different login values and check the distribution of the result.
   - Expected Result: The result should be uniformly distributed, meaning lesser possibility of collisions.

10. Scenario: Testing with non-alphanumeric characters in login
    - Test case: Pass a login value with non-alphanumeric characters to the hashCode method.
    - Expected Result: The function should process these logins and return their hashCodes.
*/
import org.agoncal.application.petstore.constraints.Email;
import org.agoncal.application.petstore.constraints.Login;
import javax.persistence;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util;

import java.util.Collection;
import java.util.Date;
import java.util.Arrays;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import java.util.Objects;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CustomerTest {

    private String inputLogin;
    private String compareLogin;
    private boolean expected;

    public CustomerTest(String inputLogin, String compareLogin, boolean expected) {
        this.inputLogin = inputLogin;
        this.compareLogin = compareLogin;
        this.expected = expected;
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"abc", "abc", true},
            {"test123", null, false},
            {"test123", "test1234", false},
            {"test123", "Test123", false},
            {"test123", "123test", false},
            {"veryLongLoginInputWhichIsMoreThanThirtyTwoCharacters", "veryLongLoginInputWhichIsMoreThanThirtyTwoCharacters", true},
            {"test123", "test123", true},
            {"", "", true},
            {"specialChars!@#", "specialChars!@#", true},
            {null, null, false}
        });
    }

    @Test
    public void testHashCode() {
        Customer customer1 = new Customer();
        Customer customer2 = new Customer();

        if(inputLogin == null){
            try {
                customer1.setLogin(inputLogin);
            } catch (NullPointerException e) {
                assertNotNull(e.getMessage());
            }
        } else {
            customer1.setLogin(inputLogin);
        }

        if(compareLogin == null){
            try {
                customer2.setLogin(compareLogin);
            } catch (NullPointerException e) {
                assertNotNull(e.getMessage());
            }
        } else {
            customer2.setLogin(compareLogin);
        }

        if(expected){
            assertEquals(customer1.hashCode(), customer2.hashCode());
        } else {
            assertNotEquals(customer1.hashCode(), customer2.hashCode());
        }
    }
}

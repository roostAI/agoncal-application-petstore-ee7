// Test generated by RoostGPT for test java-test using AI Type Azure Open AI and AI Model roost-gpt4-32k

/*
Sure, below are some of the test scenarios that could be generated:

1. `produceConfigProperty` is able to return the correct property value for an existing key.
    - Provide an InjectionPoint with an existing key.
    - Expected: The method should return the property value corresponding to that key.

2. `produceConfigProperty` returns null for a non-existing key.
    - Provide an InjectionPoint with a non-existing key.
    - Expected: The method should return null.

3. `produceConfigProperty` throws NullPointerException when `ip` or `props` is null.
    - Provide a null InjectionPoint or props.
    - Expected: The method should throw a NullPointerException.

4. Check `produceConfigProperty` tolerates spaces in the key.
    - Provide an InjectionPoint with a key that has leading/trailing spaces.
    - Expected: The method should smoothly handle this and return the corresponding value.

5. Check `produceConfigProperty` with a key having special characters.
    - Provide an InjectionPoint with a key that includes special characters.
    - Expected: The method should smoothly handle this and return the corresponding value.

6. `produceConfigProperty` returns value accurately even for case sensitive keys.
    - Provide an InjectionPoint with a key in different case than how it's in properties file.
    - Expected: The method should consider keys as case sensitive and return the appropriate value or null.

7. Check `produceConfigProperty` with an empty string as a key.
    - Provide an InjectionPoint with an empty string as a key.
    - Expected: The method should return null (if no value for empty key) or value if it exists.

Please note that the exact scenarios may vary based on the actual properties file and business logic rules.
*/
package org.agoncal.application.petstore.util;

import javax.enterprise.inject.spi.InjectionPoint;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Properties;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class ConfigPropertyProducer_produceConfigProperty_5b9fee6055_Test {

    private ConfigPropertyProducer configPropertyProducer;

    @Mock
    private InjectionPoint ip;

    @Mock
    private Properties props;

    private ConfigProperty configProperty;
    private String key;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        configPropertyProducer = new ConfigPropertyProducer();
        configProperty = new ConfigProperty();
    }

    @Test  // Provided injection point with an existing key
    public void test_produceConfigProperty_With_Existing_Key_Should_Return_Correct_Value() {
        key = "db.url";
        String value = "jdbc:mysql://localhost:3306/petstore";
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class)).thenReturn(configProperty);
        when(props.getProperty(key)).thenReturn(value);

        String actualValue = configPropertyProducer.produceConfigProperty(ip);
        assertEquals(value, actualValue);
    }

    @Test  // Provided injection point with a non-existing key
    public void test_produceConfigProperty_With_Non_Existing_Key_Should_Return_Null() {
        key = "non.existing.key";
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class)).thenReturn(configProperty);
        when(props.getProperty(key)).thenReturn(null);

        String actualValue = configPropertyProducer.produceConfigProperty(ip);
        assertNull(actualValue);
    }

    @Test(expected = NullPointerException.class)  // Provided a null InjectionPoint or props.
    public void test_produceConfigProperty_With_Null_Input_Should_Throw_NullPointerException() {
        configPropertyProducer.produceConfigProperty(null);
    }

    @Test  // Provided injection point with a key that has leading/trailing spaces
    public void test_produceConfigProperty_With_Spaces_In_Key_Should_Trim_Spaces_and_Return_Correct_Value() {
        key = " db.url ";
        String value = "jdbc:mysql://localhost:3306/petstore";
        when(ip.getAnnotated().getAnnotation(ConfigProperty.class)).thenReturn(configProperty);
        when(props.getProperty(key.trim())).thenReturn(value);

        String actualValue = configPropertyProducer.produceConfigProperty(ip);
        assertEquals(value, actualValue);
    }

    // TODO: Please populate the rest of the test cases
}

/*
1. Test Scenario: Validate the function with NULL as the InjectionPoint
    - Description: Pass NULL as the InjectionPoint to the function. Verify if the function is handling the NULL InjectionPoint without any exceptions.

2. Test Scenario: Validate the function with empty String property as InjectionPoint 
    - Description: Pass an InjectionPoint with empty String as value to the function. The function should return NULL as property doesn't exist.

3. Test Scenario: Validate the function with a valid InjectionPoint 
    - Description: Pass a valid InjectionPoint to the function, ensure it returns the correct value of the property.

4. Test Scenario: Validate function when requested config property does not exist
    - Description: Pass an InjectionPoint to the function with a property key that does not exist and ensure it returns NULL or throws an appropriate exception.

5. Test Scenario: Validate function with multiple config properties exist
    - Description: Pass an InjectionPoint to the function where multiple config properties exist and ensure it returns the correct property value.

6. Test Scenario: Validate function with same InjectionPoint called multiple times
    - Description: Pass the same InjectionPoint to the function multiple times, ensuring cached/called property retains the same value.

7. Test Scenario: Test function with large amount of data
    - Description: Use a large data set of config properties to stress test the function to evaluate its performance.

8. Test Scenario: Validate function with thread safety.
    - Description: Test the function with multiple threads to verify thread safety.

9. Test Scenario: Validate function with malformed property key.
    - Description: Pass an InjectionPoint with a malformed property key to the function and ensure it returns NULL or throws an appropriate exception.
  
10. Test Scenario: Validate the function with NULL as the property value.
    - Description: Pass an InjectionPoint with NULL as the property value to the function. Verify if the function returns NULL as the output. 

Remember these test scenarios focuses on possible edge cases, happy paths and performance related requirements. The exact scenarios could differ based on the business requirements and context of usage.
*/
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.IOException;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ConfigPropertyProducerTest {

    private static Properties props;

    @BeforeAll
    public static void setUp() {
        props = new Properties();
        props.setProperty("key1", "value1");
        props.setProperty("key2", "value2");
    }

    @Test
    public void testProduceConfigProperty_NullInjectionPoint() {
        InjectionPoint ip = null;
        String result = ConfigPropertyProducer.produceConfigProperty(ip);
        assertNull(result);
    }

    @Test
    public void testProduceConfigProperty_EmptyString() {
        InjectionPoint ip = createMockedInjectionPoint("");
        String result = ConfigPropertyProducer.produceConfigProperty(ip);
        assertNull(result);
    }

    @Test
    public void testProduceConfigProperty_ValidInjectionPoint() {
        InjectionPoint ip = createMockedInjectionPoint("key1");
        String result = ConfigPropertyProducer.produceConfigProperty(ip);
        assertEquals("value1", result);
    }

    @Test
    public void testProduceConfigProperty_NonExistingProperty() {
        InjectionPoint ip = createMockedInjectionPoint("nonExistingKey");
        String result = ConfigPropertyProducer.produceConfigProperty(ip);
        assertNull(result);
    }

    private static InjectionPoint createMockedInjectionPoint(String key) {
        InjectionPoint ip = Mockito.mock(InjectionPoint.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(ip.getAnnotated().getAnnotation(ConfigProperty.class).value()).thenReturn(key);
        return ip;
    }
}

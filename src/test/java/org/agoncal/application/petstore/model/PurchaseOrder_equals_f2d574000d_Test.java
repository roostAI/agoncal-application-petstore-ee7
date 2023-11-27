// Test generated by RoostGPT for test java-test using AI Type Azure Open AI and AI Model roost-gpt4-32k

/*
1. Scenario: Comparing a PurchaseOrder object with itself. 
- Given: A PurchaseOrder instance.
- When: I use the equals method to compare it with itself.
- Then: The method should return true as it's the same object.

2. Scenario: Comparing a PurchaseOrder object with another PurchaseOrder object that is identical.
- Given: Two identical PurchaseOrder instances.
- When: I use the equals method to compare one with the other.
- Then: The method should return true as their orderDate and customer fields are identical.

3. Scenario: Comparing a PurchaseOrder object with null.
- Given: A PurchaseOrder instance and a null reference.
- When: I use the equals method to compare the PurchaseOrder with null.
- Then: The method should return false as the method checks if the input object is null.

4. Scenario: Comparing a PurchaseOrder object with an object of a different class.
- Given: A PurchaseOrder instance and an instance of a different class.
- When: I use the equals method to compare the PurchaseOrder with the object of a different class.
- Then: The method should return false as the method checks for class type.

5. Scenario: Comparing a PurchaseOrder object with another PurchaseOrder object where orderDate is not the same.
- Given: Two PurchaseOrder instances with different orderDate.
- When: I use the equals method to compare one with the other.
- Then: The method should return false as the method validates orderDate.

6. Scenario: Comparing a PurchaseOrder object with another PurchaseOrder object where customer is not the same.
- Given: Two PurchaseOrder instances with different customer.
- When: I use the equals method to compare one with the other.
- Then: The method should return false as the method validates customer.

7. Scenario: Comparing two PurchaseOrder objects where both orderDate and customer vary.
- Given: Two PurchaseOrder instances where both the orderDate and customer differ.
- When: I use the equals method to compare one with the other.
- Then: The method should return false as both fields are different.
*/
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.agoncal.application.petstore.model.Address;
import org.agoncal.application.petstore.model.Country;
import org.agoncal.application.petstore.model.CreditCard;
import org.agoncal.application.petstore.model.Customer;
import org.agoncal.application.petstore.model.PurchaseOrder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class PurchaseOrder_equals_f2d574000d_Test {

    private static PurchaseOrder mockPurchaseOrder1, mockPurchaseOrder2;
    private static Customer mockCustomer;
    private static Date orderDate;

    @BeforeAll
    public static void setup() {
        mockCustomer = mock(Customer.class);
        orderDate = Calendar.getInstance().getTime();

        mockPurchaseOrder1 = new PurchaseOrder(mockCustomer, new CreditCard(), new Address());
        mockPurchaseOrder2 = new PurchaseOrder(mockCustomer, new CreditCard(), new Address());

        mockPurchaseOrder1.setOrderDate(orderDate);
        mockPurchaseOrder2.setOrderDate(orderDate);

        when(mockCustomer.equals(mockCustomer)).thenReturn(true);
    }

    @BeforeEach
    public void reset() {
        mockPurchaseOrder1.setOrderDate(orderDate);
        mockPurchaseOrder2.setOrderDate(orderDate);
        when(mockCustomer.equals(mockCustomer)).thenReturn(true);
    }

    @Test
    public void testEquals_SameObject() {
        assertEquals(true, mockPurchaseOrder1.equals(mockPurchaseOrder1), () -> "The equals() method should return true when comparing an instance with itself.");
    }

    @Test
    public void testEquals_IdenticalObjects() {
        assertEquals(true, mockPurchaseOrder1.equals(mockPurchaseOrder2), () -> "The equals() method should return true when comparing two identical instances.");
    }

    @Test
    public void testEquals_NullObject() {
        assertEquals(false, mockPurchaseOrder1.equals(null), () -> "The equals() method should return false when comparing an instance with null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        assertEquals(false, mockPurchaseOrder1.equals(new Object()), () -> "The equals() method should return false when comparing an instance with an object of a different class.");
    }

    @Test
    public void testEquals_VaryingOrderDate() {
        mockPurchaseOrder2.setOrderDate(new Date());
        assertEquals(false, mockPurchaseOrder1.equals(mockPurchaseOrder2), () -> "The equals() method should return false when comparing instances with varying orderDate field.");
    }

    @Test
    public void testEquals_VaryingCustomer() {
        when(mockCustomer.equals(mockCustomer)).thenReturn(false);
        assertEquals(false, mockPurchaseOrder1.equals(mockPurchaseOrder2), () -> "The equals() method should return false when comparing instances with varying customer field.");
    }

    @Test
    public void testEquals_VaryingOrderDateAndCustomer() {
        mockPurchaseOrder2.setOrderDate(new Date());
        when(mockCustomer.equals(mockCustomer)).thenReturn(false);
        assertEquals(false, mockPurchaseOrder1.equals(mockPurchaseOrder2), () -> "The equals() method should return false when comparing instances with both orderDate and customer fields varying.");
    }
}

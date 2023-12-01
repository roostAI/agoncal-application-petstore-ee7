/*
1. Scenario: Validate that the hashCode function returns a proper hash value for given orderDate and customer. 
Expected: Return integer value.

2. Scenario: Check that the hashCode function returns same hash on subsequent calls with same inputs.
Expected: The hash value should be the same for repeat calls with the same input values.

3. Scenario: Compare hashCode when two different objects have the same orderDate and customer. 
Expected: The hash value should be the same.

4. Scenario: Compare hashCode when two different objects have same orderDate but different customer. 
Expected: The hash value should not be the same.

5. Scenario: Compare hashCode when two different objects have different orderDate but same customer. 
Expected: The hash value should not be the same.

6. Scenario: Compare hashCode when two different objects have different orderDate and customer. 
Expected: The hash value should not be the same.

7. Scenario: Validate the hashCode function when null values are given for orderDate and customer. 
Expected: The hashCode function should return 0.

8. Scenario: Validate hashCode function when orderDate is given and customer is set to null. 
Expected: The hashCode function should return a non-zero value that corresponds to the hash of the orderDate.

9. Scenario: Validate hashCode function when customer is given and orderDate is set to null. 
Expected: The hashCode function should return a non-zero value that corresponds to the hash of the customer.

10. Scenario: Check for the uniqueness of hashCode for a large number of different Objects with different orderDate and customer. 
Expected: hashCode should be as unique as possible, confirming that it disperses orderDate and customer properly.

11. Scenario: Verify that hashCode function works with the earliest and latest possible dates for orderDate.
Expected: It should return a valid hash code without any exception.

12. Scenario: Evaluate the performance of the hashCode function when it is invoked multiple times for the same orderDate and customer. 
Expected: It should consistently return the same value quickly.
*/
package org.agoncal.application.petstore.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PurchaseOrder_hashCode_5a2657087a_Test {

    private PurchaseOrder purchaseOrder;

    @BeforeEach
    public void setUp() {
        purchaseOrder = new PurchaseOrder();
    }

    @Test
    public void testHashCodeSameForSameOrderDateAndCustomer() {
        Date date = new Date();
        Customer customer = new Customer();
        purchaseOrder.setOrderDate(date);
        purchaseOrder.setCustomer(customer);

        assertEquals(purchaseOrder.hashCode(), Objects.hash(date, customer));
    }

    @Test
    public void testHashCodeSameForSameInputsMultipleCalls() {
        Date date = new Date();
        Customer customer = new Customer();
        purchaseOrder.setOrderDate(date);
        purchaseOrder.setCustomer(customer);

        int firstHashCode = purchaseOrder.hashCode();
        int secondHashCode = purchaseOrder.hashCode();

        assertEquals(firstHashCode, secondHashCode);
    }

    @Test
    public void testHashCodeDifferentForDifferentOrderDate() {
        PurchaseOrder purchaseOrder1 = new PurchaseOrder();
        purchaseOrder1.setOrderDate(new Date());
        purchaseOrder1.setCustomer(new Customer());

        PurchaseOrder purchaseOrder2 = new PurchaseOrder();
        purchaseOrder2.setOrderDate(new Date(987654321L)); // different date
        purchaseOrder2.setCustomer(purchaseOrder1.getCustomer()); // same customer

        assertNotEquals(purchaseOrder1.hashCode(), purchaseOrder2.hashCode());
    }

    @Test
    public void testHashCodeDifferentForDifferentCustomer() {
        PurchaseOrder purchaseOrder1 = new PurchaseOrder();
        purchaseOrder1.setOrderDate(new Date());
        purchaseOrder1.setCustomer(new Customer());

        PurchaseOrder purchaseOrder2 = new PurchaseOrder();
        purchaseOrder2.setOrderDate(purchaseOrder1.getOrderDate()); // same date
        purchaseOrder2.setCustomer(new Customer()); // different customer

        assertNotEquals(purchaseOrder1.hashCode(), purchaseOrder2.hashCode());
    }

    @Test
    public void testHashCodeNotNullOrderDateCustomerNull() {
        purchaseOrder.setOrderDate(new Date());
        purchaseOrder.setCustomer(null);

        assertNotEquals(0, purchaseOrder.hashCode());
    }

    @Test
    public void testHashCodeNullOrderDateNotNullCustomer() {
        purchaseOrder.setOrderDate(null);
        purchaseOrder.setCustomer(new Customer());

        assertNotEquals(0, purchaseOrder.hashCode());
    }

    @Test
    public void testHashCodeNullOrderDateCustomer() {
        purchaseOrder.setOrderDate(null);
        purchaseOrder.setCustomer(null);

        assertEquals(0, purchaseOrder.hashCode());
    }

    @Test
    public void testHashCodeUniqueValuesForLargeSetOfDatesAndCustomers() {
        PurchaseOrder[] purchaseOrders = new PurchaseOrder[1000000];
        for (int i = 0; i < 1000000; i++) {
            PurchaseOrder po = new PurchaseOrder();
            po.setOrderDate(new Date(i));
            Customer customer = new Customer();
            customer.setLogin(String.valueOf(i));
            po.setCustomer(customer);
            purchaseOrders[i] = po;
        }

        for (int i = 0; i < 1000000; i++) {
            for (int j = i + 1; j < 1000000; j++) {
                assertNotEquals(purchaseOrders[i].hashCode(), purchaseOrders[j].hashCode());
            }
        }
    }

    @Test
    public void testHashCodeEarliestAndLatestPossibleDates() {
        PurchaseOrder po1 = new PurchaseOrder();
        po1.setOrderDate(new Date(Long.MIN_VALUE));

        PurchaseOrder po2 = new PurchaseOrder();
        po2.setOrderDate(new Date(Long.MAX_VALUE));

        assertNotEquals(0, po1.hashCode());
        assertNotEquals(0, po2.hashCode());

        assertNotEquals(po1.hashCode(), po2.hashCode());
    }
}

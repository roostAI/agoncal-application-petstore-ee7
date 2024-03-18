// ********RoostGPT********
/*
Test generated by RoostGPT for test agoncal-application-petstore-ee7 using AI Type Open AI and AI Model gpt-4

ROOST_METHOD_HASH=equals_9577507f17
ROOST_METHOD_SIG_HASH=equals_f2d574000d

"""
Scenario 1: Test for equality with the same object

TestName: testEqualityWithSameObject
Description: This test checks if the equals method returns true when the same object is passed as the parameter.
Execution:
  Arrange: Create an OrderLine object.
  Act: Invoke the equals method passing the same object as the parameter.
  Assert: The result should be true.
Validation: 
  The equals method is supposed to return true when the same object is passed as the parameter. This test validates this functionality.

Scenario 2: Test for equality with null

TestName: testEqualityWithNull
Description: This test checks if the equals method returns false when null is passed as the parameter.
Execution:
  Arrange: Create an OrderLine object.
  Act: Invoke the equals method passing null as the parameter.
  Assert: The result should be false.
Validation:
  The equals method is supposed to return false when null is passed as the parameter. This test validates this functionality.

Scenario 3: Test for equality with different class object

TestName: testEqualityWithDifferentClassObject
Description: This test checks if the equals method returns false when an object of a different class is passed as the parameter.
Execution:
  Arrange: Create an OrderLine object and an object of a different class.
  Act: Invoke the equals method passing the object of a different class as the parameter.
  Assert: The result should be false.
Validation:
  The equals method is supposed to return false when an object of a different class is passed as the parameter. This test validates this functionality.

Scenario 4: Test for equality with different OrderLine object

TestName: testEqualityWithDifferentOrderLineObject
Description: This test checks if the equals method returns false when a different OrderLine object is passed as the parameter.
Execution:
  Arrange: Create two different OrderLine objects.
  Act: Invoke the equals method of the first object passing the second object as the parameter.
  Assert: The result should be false.
Validation:
  The equals method is supposed to return false when a different OrderLine object is passed as the parameter. This test validates this functionality.

Scenario 5: Test for equality with identical OrderLine object

TestName: testEqualityWithIdenticalOrderLineObject
Description: This test checks if the equals method returns true when an identical OrderLine object is passed as the parameter.
Execution:
  Arrange: Create two identical OrderLine objects.
  Act: Invoke the equals method of the first object passing the second object as the parameter.
  Assert: The result should be true.
Validation:
  The equals method is supposed to return true when an identical OrderLine object is passed as the parameter. This test validates this functionality.
"""
*/

// ********RoostGPT********
package org.agoncal.application.petstore.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrderLineEqualsTest {

    @Test
    public void testEqualityWithSameObject() {
        Item item = new Item("Item1", 10f, "path1", "desc1", new Product());
        OrderLine orderLine = new OrderLine(5, item);
        assertTrue(orderLine.equals(orderLine));
    }

    @Test
    public void testEqualityWithNull() {
        Item item = new Item("Item1", 10f, "path1", "desc1", new Product());
        OrderLine orderLine = new OrderLine(5, item);
        assertFalse(orderLine.equals(null));
    }

    @Test
    public void testEqualityWithDifferentClassObject() {
        Item item = new Item("Item1", 10f, "path1", "desc1", new Product());
        OrderLine orderLine = new OrderLine(5, item);
        assertFalse(orderLine.equals(new String("test")));
    }

    @Test
    public void testEqualityWithDifferentOrderLineObject() {
        Item item1 = new Item("Item1", 10f, "path1", "desc1", new Product());
        OrderLine orderLine1 = new OrderLine(5, item1);

        Item item2 = new Item("Item2", 20f, "path2", "desc2", new Product());
        OrderLine orderLine2 = new OrderLine(10, item2);

        assertFalse(orderLine1.equals(orderLine2));
    }

    @Test
    public void testEqualityWithIdenticalOrderLineObject() {
        Item item1 = new Item("Item1", 10f, "path1", "desc1", new Product());
        OrderLine orderLine1 = new OrderLine(5, item1);

        Item item2 = new Item("Item1", 10f, "path1", "desc1", new Product());
        OrderLine orderLine2 = new OrderLine(5, item2);

        assertTrue(orderLine1.equals(orderLine2));
    }
}

package org.agoncal.application.petstore.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderLine_hashCode_5a2657087a_Test {

    private OrderLine orderLine;
    private Item item;

    @Before
    public void setup() {
        // TODO: Replace with real `item` object initialization as needed
        item = new Item();
        item.setId(1L);
        item.setName("TestItem");
        item.setUnitCost(10.0f);

        // TODO: Replace with real `orderLine` object initialization as needed
        orderLine = new OrderLine(2, item);
    }

    @Test
    public void generateValidHashCodeForNonNullFields() {
        // Arrange (done in setup)
        int expectedHashCode = Objects.hash(orderLine.getQuantity(), orderLine.getItem());

        // Act
        int actualHashCode = orderLine.hashCode();

        // Assert
        assertEquals("The hash code should match the expected hash code.", expectedHashCode, actualHashCode);
    }

    @Test
    public void ensureConsistentHashCodeForUnchangedObject() {
        // Arrange (done in setup)
        int initialHashCode = orderLine.hashCode();

        // Act and Assert
        for (int i = 0; i < 10; i++) {
            assertEquals("The hash code should be consistent for an unchanged object.", initialHashCode, orderLine.hashCode());
        }
    }

    @Test
    public void generateDifferentHashCodesForDistinctObjects() {
        // Arrange
        Item differentItem = new Item();
        differentItem.setId(2L);
        differentItem.setName("AnotherTestItem");
        differentItem.setUnitCost(20.0f);

        OrderLine differentOrderLine = new OrderLine(3, differentItem);

        // Act
        int hashCode1 = orderLine.hashCode();
        int hashCode2 = differentOrderLine.hashCode();

        // Assert
        assertNotEquals("Hash codes should be different for distinct objects.", hashCode1, hashCode2);
    }

    @Test
    public void nullFieldsHashCodeGeneration() {
        // Arrange
        OrderLine orderLineWithNullFields = new OrderLine();
        orderLineWithNullFields.setQuantity(null);
        orderLineWithNullFields.setItem(null);

        // Act
        int hashCode = orderLineWithNullFields.hashCode();

        // Assert
        assertNotNull("The hash code should be generated without throwing an exception.", hashCode);
    }

    @Test
    public void zeroValueFieldsHashCodeGeneration() {
        // Arrange
        orderLine.setQuantity(0);

        // Act
        int hashCode = orderLine.hashCode();

        // Assert
        assertNotNull("The hash code should be generated correctly even if quantity is zero.", hashCode);
    }
}


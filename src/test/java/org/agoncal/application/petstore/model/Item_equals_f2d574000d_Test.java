/*
1. Test when the `equals` method is called with exactly the same object instance as the argument. Expectation: The method should return `true`.

2. Test when the `equals` method is called with null as the argument. Expectation: The method should return `false`.

3. Test when the `equals` method is called with an object of a different class as the argument. Expectation: The method should return `false`.

4. Test when the `equals` method is called with an object of the same class but different `name` and `description` properties. Expectation: The method should return `false`.

5. Test when the `equals` method is called with an object of the same class and the same `name`, but the different `description` property. Expectation: The method should return `false`.

6. Test when the `equals` method is called with an object of the same class, the same `description`, but different `name` property. Expectation: The method should return `false`.

7. Test when the `equals` method is called with an object of the same class and the same `name` and `description` properties. Expectation: The method should return `true`.

8. Test when two objects have the same `name` and `description` but different data in other fields (if they exist). The expectation is the `equals` method would return `true` as it only compares `name` and `description`.

9. Test when null `name` or `description` exists in either the object or the parameter. The expectation is the `equals` method would throw a Null Pointer Exception.

10. Test when the `equals` method is called with an object where `name` and `description` are empty strings. Expectation: The method should return `false` if the calling object's `name` and `description` are not empty. 

Please note: these test cases are based on the assumption that the `name` and `description` properties are strings and cannot be null. Further testing may be required if these conditions are not met.
*/
import org.agoncal.application.petstore.constraints.NotEmpty;
import org.agoncal.application.petstore.constraints.Price;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    Item item1, item2;
    Product product;

    @Before
    public void setup() {
        product = new Product();
        item1 = new Item();
        item1.setName("item1");
        item1.setDescription("description1");
        item1.setProduct(product);

    }

    @Test
    public void testEqualsSameInstance() {
        assertTrue(item1.equals(item1));
    }

    @Test
    public void testEqualsNullArgument() {
        assertFalse(item1.equals(null));
    }

    @Test
    public void testEqualsDifferentClass() {
        assertFalse(item1.equals(new String("Item1")));
    }

    @Test
    public void testEqualsDifferentNameDescription() {
        item2 = new Item();
        item2.setName("item2");
        item2.setDescription("description2");
        assertFalse(item1.equals(item2));
    }

    @Test
    public void testEqualsSameNameDifferentDescription() {
        item2 = new Item();
        item2.setName("item1");
        item2.setDescription("description2");
        assertFalse(item1.equals(item2));
    }

    @Test
    public void testEqualsDifferentNameSameDescription() {
        item2 = new Item();
        item2.setName("item2");
        item2.setDescription("description1");
        assertFalse(item1.equals(item2));
    }

    @Test
    public void testEqualsSameNameDescription() {
        item2 = new Item();
        item2.setName("item1");
        item2.setDescription("description1");
        assertFalse(item1.equals(item2));
    }

    @Test(expected=NullPointerException.class)
    public void testEqualsNullName() {
        item1.setName(null);
        item2 = new Item();
        assertFalse(item1.equals(item2));
    }

    @Test
    public void testEqualsEmptyStrings() {
        item2 = new Item();
        item2.setName("");
        item2.setDescription("");
        assertFalse(item1.equals(item2));
    }
}

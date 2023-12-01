/*
Scenario 1: Same Object Comparison
Given same 'Product' object is provided 
Then the function should return true as two references point to the same object

Scenario 2: Different Class Objects Comparison
Given an object of different class is provided
Then the function should return false as they are not instances of the same class

Scenario 3: Null Object Comparison
Given a NULL object is passed 
Then the function should return false as any object is not equal to null

Scenario 4: Two Different Product objects with Same name & description
Given two 'Product' instances with the same 'name' and 'description' 
Then the function should return true as their properties match

Scenario 5: Two Different Product objects with Different name or description
Given two 'Product' instances with either different 'name' or 'description'
Then the function should return false as their properties don't match

Scenario 6: Product object with NULL name or description
Given a 'Product' instance with NULL 'name' or 'description'
Then the function should handle NullPointerException

Scenario 7: Product object with non-null name or description
Given a 'Product' instance with non-null 'name' or 'description'
Then the function should not throw any exception
*/
import org.agoncal.application.petstore.model.Category;
import org.agoncal.application.petstore.model.Product;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Product_equals_f2d574000d_Test {

    @Test
    public void testEqualsSameInstance() {
        Product product = new Product();
        product.setName("product1");
        product.setDescription("description1");
        Category category = new Category();
        category.setName("category1");
        category.setDescription("categoryDesc1");
        product.setCategory(category);
        assertTrue(product.equals(product));
    }

    @Test
    public void testEqualsDifferentClass() {
        Product product = new Product();
        product.setName("product1");
        product.setDescription("description1");
        Category category = new Category();
        category.setName("category1");
        category.setDescription("categoryDesc1");
        product.setCategory(category);
        assertFalse(product.equals(new String("test")));
    }

    @Test
    public void testEqualsNullValue() {
        Product product = new Product();
        product.setName("product1");
        product.setDescription("description1");
        Category category = new Category();
        category.setName("category1");
        category.setDescription("categoryDesc1");
        product.setCategory(category);
        assertFalse(product.equals(null));
    }

    @Test
    public void testEquals_ProductsWithSameNameAndDescription() {
        Product product1 = new Product();
        product1.setName("product1");
        product1.setDescription("description1");
        Category category1 = new Category();
        category1.setName("category1");
        category1.setDescription("categoryDesc1");
        product1.setCategory(category1);

        Product product2 = new Product();
        product2.setName("product1");
        product2.setDescription("description1");
        Category category2 = new Category();
        category2.setName("category2");
        category2.setDescription("categoryDesc2");
        product2.setCategory(category2);

        assertTrue(product1.equals(product2));
    }

    @Test
    public void testEquals_ProductsWithDifferentName() {
        Product product1 = new Product();
        product1.setName("product1");
        product1.setDescription("description1");
        Category category1 = new Category();
        category1.setName("category1");
        category1.setDescription("categoryDesc1");
        product1.setCategory(category1);

        Product product2 = new Product();
        product2.setName("product2");
        product2.setDescription("description1");
        Category category2 = new Category();
        category2.setName("category2");
        category2.setDescription("categoryDesc2");
        product2.setCategory(category2);

        assertFalse(product1.equals(product2));
    }

    @Test(expected = NullPointerException.class)
    public void testEquals_ProductWithNullName() {
        Product product1 = new Product();
        product1.setName(null);
        product1.setDescription("description1");
        Category category1 = new Category();
        category1.setName("category1");
        category1.setDescription("categoryDesc1");
        product1.setCategory(category1);

        Product product2 = new Product();
        product2.setName("product1");
        product2.setDescription("description1");
        Category category2 = new Category();
        category2.setName("category2");
        category2.setDescription("categoryDesc2");
        product2.setCategory(category2);

        product1.equals(product2);
    }

    @Test
    public void testEquals_ProductWithNonNullName() {
        Product product1 = new Product();
        product1.setName("product1");
        product1.setDescription("description1");
        Category category1 = new Category();
        category1.setName("category1");
        category1.setDescription("categoryDesc1");
        product1.setCategory(category1);

        Product product2 = new Product();
        product2.setName("product1");
        product2.setDescription("description2");
        Category category2 = new Category();
        category2.setName("category2");
        category2.setDescription("categoryDesc2");
        product2.setCategory(category2);

        assertFalse(product1.equals(product2));
    }
}

/*
1. Scenario: Comparing the object with itself
   Test: Compare a `Customer` object with itself using `equals()` method. 
   Expected result: The `equals()` method should return `true`.

2. Scenario: Comparing a `Customer` object to null
   Test: Compare a `Customer` object with null using `equals()` method. 
   Expected result: The `equals()` method should return `false`.

3. Scenario: Comparing a `Customer` object to a different class object
   Test: Compare `Customer` object with an object of a different class.
   Expected result: The `equals()` method should return `false`

4. Scenario: Comparing two `Customer` objects with same `login`
   Test: Create two different `Customer` objects with the same `login` value and compare them using `equals()` method.
   Expected result: The `equals()` method should return `true`.

5. Scenario: Comparing two `Customer` objects with different `login`
   Test: Create two different `Customer` objects with different `login` value and compare them using `equals()` method. 
   Expected result: The `equals()` method should return `false`.

6. Scenario: Comparing a `Customer` object with a `Customer` object with null `login`
   Test: Compare a `Customer` object with a `login` to a `Customer` object with null `login`. 
   Expected result: The `equals()` method should return `false`.

7. Scenario: Comparing two `Customer` objects both having null `login`
   Test: Compare two `Customer` objects both having null `login`.
   Expected result: The `equals()` method should return `true`.
*/
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>

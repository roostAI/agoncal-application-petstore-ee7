/*
1. Verify two OrderLine objects with the same 'quantity' and 'item' are considered equal. 

2. Check the function when the 'quantity' is the same but the 'item' differs in two OrderLine objects. The result should be false. 

3. Test the function when the 'quantity' differs but the 'item' is the same for two OrderLine objects. The result should be false.

4. Test by passing a null object to the equals method. It should return false.

5. Validate the function for an object of a different class. This should return false, as the object is not an instance of OrderLine. 

6. Test with passing 'this' object (OrderLine object itself) to equals method. The function should return true, as both objects are identical. 

7. Test the scenario where both OrderLine objects have null for either 'quantity' or 'item' or both. The function's behavior in this case depends on how the 'equals' method of the 'quantity' and 'item' attributes are implemented. 

8. Check the function for two completely different OrderLine objects. It should return false. 

9. Test for case sensitivity in the 'item' field, if it's a string. For example, check whether 'item1' and 'Item1' are considered equal or not. 

10. If 'item' or/and 'quantity' contain special characters, verify if equal objects are considered equal by the function. 

11. Verify the equals function handles minimum values (@Min) if any validation rule exists for 'quantity' or 'item'.

Note: The output of test scenarios could change based on how the equals method is implemented in 'quantity' and 'item' classes.
*/
import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class OrderLine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    @Min(1)
    private Integer quantity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_fk", nullable = false)
    private Item item;

    public OrderLine() {}

    public Float getSubTotal(){
        return item.getUnitCost() * quantity;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return this.item;
    }

    public void setItem(final Item item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OrderLine orderLine = (OrderLine) o;
        return quantity.equals(orderLine.quantity) && item.equals(orderLine.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, item);
    }

    @Override
    public String toString() {
        return "OrderLine{" + "id=" + id + ", version=" + version + ", quantity=" + quantity + ", item=" + item + '}';
    }

}

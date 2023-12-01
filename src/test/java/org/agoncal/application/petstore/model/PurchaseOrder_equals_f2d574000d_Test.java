/*
Here are the test scenarios for this equals method in the PurchaseOrder class:

1. Test when both PurchaseOrder objects are identical:
    - Create two identical PurchaseOrder objects and test if the method returns true.

2. Test when the compared object is null:
    - Compare the PurchaseOrder object to null. The method should return false.

3. Test when the compared object is a different type:
    - Compare the PurchaseOrder object with an object of a different class. The method should return false.

4. Test when the orderDate property of the two PurchaseOrder objects is different:
    - Create two PurchaseOrder objects, identical except with different orderDates. The method should return false.

5. Test when the customer property of the two PurchaseOrder objects is different:
    - Create two PurchaseOrder objects, identical except for different customers. The method should return false.

6. Test when the customer property in one of the PurchaseOrder objects is null:
    - Create two PurchaseOrder objects, identical except that one doesn't have a customer. The method should return false.

7. Test when the orderDate property in one of the PurchaseOrder objects is null:
    - Create two PurchaseOrder objects, identical except that one doesn't have an orderDate. The method should return false.

8. Test when both the orderDate and customer properties are null in the two PurchaseOrder objects:
    - Create two PurchaseOrder objects, identical except that both don't have an orderDate and a customer. The method should return false - as null values shouldn't match with each other.
  
9. Test with larger data set:
   - Create two purchase order objects with larger dataset and check whether the equals method is still working as expected. 

Remember, as the equals method uses `getClass` for comparison, it won't work if subclasses of `PurchaseOrder` are involved. In such cases it's recommended to use `instanceof` for checking, which handles subclasses as well.

Also, please make sure that you are overriding the equals method in both the classes used for comparison i.e Purchase Order and Customer.
*/
import javax.persistence.*;
import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XmlRootElement
@NamedQuery(name = PurchaseOrder.FIND_ALL, query = "SELECT o FROM PurchaseOrder o")
public class PurchaseOrder implements Serializable {

    public static final String FIND_ALL = "Order.findAll";

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    private Float totalWithoutVat;

    private Float vatRate;

    private Float vat;

    private Float totalWithVat;

    private Float discountRate;

    private Float discount;

    private Float total;

    @ManyToOne
    @JoinColumn(name = "customer_fk")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderLine> orderLines = new HashSet<>();

    @Embedded
    private Address deliveryAddress = new Address();

    @Embedded
    private CreditCard creditCard = new CreditCard();

    public void setDefaultData() {
        orderDate = new Date();
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Float getTotalWithoutVat() {
        return totalWithoutVat;
    }

    public void setTotalWithoutVat(Float totalWithoutVat) {
        this.totalWithoutVat = totalWithoutVat;
    }

    public Float getVatRate() {
        return vatRate;
    }

    public void setVatRate(Float vatRate) {
        this.vatRate = vatRate;
    }

    public Float getVat() {
        return vat;
    }

    public void setVat(Float vat) {
        this.vat = vat;
    }

    public Float getTotalWithVat() {
        return totalWithVat;
    }

    public void setTotalWithVat(Float totalWithVat) {
        this.totalWithVat = totalWithVat;
    }

    public Float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Float discountRate) {
        this.discountRate = discountRate;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public Set<OrderLine> getOrderLines() {
        return this.orderLines;
    }

    public void setOrderLines(final Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrder that = (PurchaseOrder) o;
        return orderDate.equals(that.orderDate) && customer.equals(that.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDate, customer);
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" + "id=" + id + ", version=" + version + ", orderDate=" + orderDate + ", totalWithoutVat=" + totalWithoutVat + ", vatRate=" + vatRate + ", vat=" + vat + ", totalWithVat=" + totalWithVat + ", discountRate=" + discountRate + ", discount=" + discount + ", total=" + total + ", customer=" + customer + ", orderLines=" + orderLines + ", deliveryAddress=" + deliveryAddress + ", creditCard=" + creditCard + '}';
    }
}

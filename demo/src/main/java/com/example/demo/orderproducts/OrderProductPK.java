package com.example.demo.orderproducts;

import com.example.demo.orders.Order;
import com.example.demo.products.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderProductPK implements Serializable {

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    // standard getters and setters
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // hashcode() and equals() methods
    @Override
    public String toString() {
        return "OrderProductPK{" +
                "order=" + order +
                ", product=" + product +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}

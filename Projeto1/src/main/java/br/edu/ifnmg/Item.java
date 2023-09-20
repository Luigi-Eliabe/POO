package br.edu.ifnmg;

import java.math.BigDecimal;

public class Item {
    private Integer quantity;
    private Product product;

    public BigDecimal totalCalc() {
        BigDecimal quantityBigDecimal = new BigDecimal(quantity);
        return product.getPrice().multiply(quantityBigDecimal);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return product.getName() + " " + quantity + " x R$" + product.getPrice() +
                " = R$ " + totalCalc();
    }
}
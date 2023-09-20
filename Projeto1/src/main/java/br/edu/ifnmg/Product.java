package br.edu.ifnmg;

import java.math.BigDecimal;

public class Product {
    private String name; // max ch 150
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() > 150) {
            throw new Exception("Excedido tamanho maximo de 150 caracteres");
        }
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Product(String name, BigDecimal price) throws Exception {
        setName(name);
        setPrice(price);
    }

    @Override
    public String toString() {
        return name + " R$" + price;
    }

}
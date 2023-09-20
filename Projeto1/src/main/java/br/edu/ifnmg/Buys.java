package br.edu.ifnmg;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Buys {
    private Person person;
    private Long invoice;
    private ArrayList<Item> itens;

    public Buys(Person person, String invoice, ArrayList<Item> itens) {
        setPerson(person);
        setInvoice(invoice);
        setItens(itens);
    }

    public Buys() {
        this.itens = new ArrayList<>();
    }

    public BigDecimal totalCalc() {
        BigDecimal sum = new BigDecimal(0);
        for (Item item : itens) {
            sum = sum.add(item.totalCalc());
        }
        return sum;
    }

    public Long getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {

        for (int i = 0; i < invoice.length(); i++) {
            if (invoice.charAt(i) != '0') {
                invoice = invoice.substring(i);
                break;
            }
        }

        this.invoice = Long.parseLong(invoice);
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    private static String formatNumber(Long number) {
        String numberStr = String.format("%09d", number);
        return numberStr.substring(0, 3) + "." + numberStr.substring(3, 6) + "." + numberStr.substring(6);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void addIten(Item itens) {
        this.itens.add(itens);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("; [");

        for (int i = 0; i < itens.size(); i++) {
            stringBuilder.append("Item ").append(i + 1).append(": ").append(itens.get(i));
            if (i < itens.size() - 1) {
                stringBuilder.append("; ");
            }
        }

        stringBuilder.append("]");

        return "Nota fiscal: " + formatNumber(invoice) + "; Cliente: " + person.getName() + "; R$ " +
                totalCalc() + stringBuilder;
    }

}
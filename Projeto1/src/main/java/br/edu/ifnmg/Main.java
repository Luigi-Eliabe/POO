package br.edu.ifnmg;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        try {
            Credential cred1 = new Credential("ana.zaira@mail.com", "asdf123", Boolean.TRUE, p1);
            p1.setCredential(cred1);
            Credential cred2 = new Credential("beatriz.yana@mail.com", "123asdf", Boolean.FALSE, p2);
            p2.setCredential(cred2);
            Credential cred3 = new Credential("cecilia.xerxes@mail.com", "123123", Boolean.FALSE, p3);
            p3.setCredential(cred3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            p1.setName("Ana Zaira");
            p1.setDateBorn(LocalDate.parse("2000-01-29"));
            p2.setName("Beatriz Yana");
            p2.setDateBorn(LocalDate.parse("1999-01-28"));
            p3.setName("Cecília Xerxes");
            p3.setDateBorn(LocalDate.parse("1998-01-27"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            p1.addAdress(new Adress(Adress.AdressType.RUA, "A1", 1011, "Santa Ana I", 39401111));
            p1.addAdress(new Adress(Adress.AdressType.RUA, "A2", 1012, "Santa Ana II", 39401112));
            p2.addAdress(new Adress(Adress.AdressType.RUA, "B", 2022, "Santa Beatriz", 39402222));
            p3.addAdress(new Adress(Adress.AdressType.RUA, "C1", 3031, " Santa Cecília I", 39403331));
            p3.addAdress(new Adress(Adress.AdressType.RUA, "C2", 3032, "Santa Cecília II", 39403332));
            p3.addAdress(new Adress(Adress.AdressType.RUA, "C3", 3033, "Santa Cecília III", 39403333));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        p1.addCellphones(new CellPhone((byte) 38, 12341234));
        p2.addCellphones(new CellPhone((byte) 38, 23452345));
        p2.addCellphones(new CellPhone((byte) 38, 923452345));
        p3.addCellphones(new CellPhone((byte) 38, 934563456));
        p3.addCellphones(new CellPhone((byte) 38, 834563456));
        Buys buysP1 = new Buys();
        ArrayList<Buys> buysP2 = new ArrayList<>();
        buysP2.add(new Buys());
        buysP2.add(new Buys());
        Buys buysP3 = new Buys();
        try {
            buysP1.addIten(new Item());
            buysP1.getItens().get(0).setQuantity(11);
            buysP1.getItens().get(0).setProduct((new Product("Abacaxi", BigDecimal.valueOf(1.99))));
            buysP1.setInvoice("000100101");
            buysP1.setPerson(p1);
            p1.addBuys(buysP1);
            for (int i = 1; i <= 4; i++) {
                buysP2.get(0).addIten(new Item());
                buysP2.get(0).getItens().get(i - 1).setQuantity(10 + i);
            }
            buysP2.get(0).getItens().get(0).setProduct((new Product("Banana", BigDecimal.valueOf(2.99))));
            buysP2.get(0).getItens().get(1).setProduct((new Product("Caqui", BigDecimal.valueOf(3.99))));
            buysP2.get(0).getItens().get(2).setProduct((new Product("Damasco", BigDecimal.valueOf(4.99))));
            buysP2.get(0).getItens().get(3).setProduct((new Product("Espinafre", BigDecimal.valueOf(5.99))));
            buysP2.get(0).setInvoice("000200202");
            buysP2.get(0).setPerson(p2);

            buysP2.get(1).addIten(new Item());
            buysP2.get(1).addIten(new Item());
            buysP2.get(1).addIten(new Item());
            buysP2.get(1).getItens().get(0).setQuantity(21);
            buysP2.get(1).getItens().get(1).setQuantity(22);
            buysP2.get(1).getItens().get(2).setQuantity(23);

            buysP2.get(1).getItens().get(0).setProduct((new Product("Abacaxi", BigDecimal.valueOf(1.99))));
            buysP2.get(1).getItens().get(1).setProduct((new Product("Caqui", BigDecimal.valueOf(3.99))));
            buysP2.get(1).getItens().get(2).setProduct((new Product("Espinafre", BigDecimal.valueOf(5.99))));
            buysP2.get(1).setInvoice("000200212");
            buysP2.get(1).setPerson(p2);
            p2.setBuys(buysP2);
            buysP3.addIten(new Item());
            buysP3.addIten(new Item());
            buysP3.addIten(new Item());
            buysP3.getItens().get(0).setQuantity(31);
            buysP3.getItens().get(1).setQuantity(32);
            buysP3.getItens().get(2).setQuantity(33);

            buysP3.getItens().get(0).setProduct(new Product("Abacaxi", BigDecimal.valueOf(1.99)));
            buysP3.getItens().get(1).setProduct(new Product("Caqui", BigDecimal.valueOf(3.99)));
            buysP3.getItens().get(2).setProduct(new Product("Espinafre", BigDecimal.valueOf(5.99)));
            buysP3.setInvoice("000300303");
            buysP3.setPerson(p3);
            p3.addBuys(buysP3);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(p1.toString());
        System.out.println("\n---------------------------------------------------------------------------\n");
        System.out.println(p2.toString());
        System.out.println("\n---------------------------------------------------------------------------\n");
        System.out.println(p3.toString());

    }
}
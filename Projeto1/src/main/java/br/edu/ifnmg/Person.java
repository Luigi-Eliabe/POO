package br.edu.ifnmg;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Person {
    private String name;
    private LocalDate dateBorn;
    private Byte age;
    private Credential credential;
    private ArrayList<Adress> adresses;
    private ArrayList<CellPhone> cellphones;
    private ArrayList<Buys> buys;

    public Person() {
        this.adresses = new ArrayList<>();
        this.cellphones = new ArrayList<>();
        this.buys = new ArrayList<>();
    }

    public Person(String name, LocalDate dateBorn, Byte age, Credential credential, ArrayList<Adress> adresses,
                  ArrayList<CellPhone> telephones, ArrayList<Buys> buys) throws Exception {
        setName(name);
        setDateBorn(dateBorn);
        setCredential(credential);
        setAdresses(adresses);
        setCellphones(cellphones);
        setBuys(buys);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() > 45) {
            throw new Exception("Excedido tamanho maximo de 45 caracteres");
        }
        this.name = name;
    }

    public LocalDate getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(LocalDate dateBorn) {
        this.dateBorn = dateBorn;
        setAge();
    }

    public Byte getAge() {
        return age;
    }

    private void setAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(dateBorn, today);
        this.age = (byte) period.getYears();
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public ArrayList<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(ArrayList<Adress> adresses) {
        this.adresses = adresses;
    }

    public ArrayList<CellPhone> getCellphones() {
        return cellphones;
    }

    public void setCellphones(ArrayList<CellPhone> telephones) {
        this.cellphones = telephones;
    }

    public ArrayList<Buys> getBuys() {
        return buys;
    }

    public void setBuys(ArrayList<Buys> buys) {
        this.buys = buys;
    }

    public void addAdress(Adress adress) {
        this.adresses.add(adress);
    }

    public void addBuys(Buys buys) {
        this.buys.add(buys);
    }

    public void addCellphones(CellPhone telephone) {
        this.cellphones.add(telephone);
    }

    @Override
    public String toString() {
        StringBuilder adressesString = new StringBuilder("Endereços: [ ");
        for (Adress x : this.adresses) {
            adressesString.append(x.toString()).append("; ");
        }
        adressesString.append("] ");
        StringBuilder telephonesString = new StringBuilder("Telefones: [ ");
        for (CellPhone x : this.cellphones) {
            telephonesString.append(x.toString()).append("; ");
        }
        telephonesString.append("] ");
        BigDecimal totalValue = new BigDecimal("0.0");
        StringBuilder buysString = new StringBuilder("Compras: [ ");
        for (Buys x : this.buys) {
            // buysString += x.getInvoice() + ", " + x.totalCalc().toString() + "; ";
            buysString.append(x.toString()).append("; ");
            totalValue = totalValue.add(x.totalCalc());
        }
        buysString.append("] ");

        String formattedDate = this.dateBorn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return (this.name + ", " + formattedDate + ", " + this.age.intValue() + " anos, " + this.credential.getEmail() +
                ", Senha: '" +this.credential.getPassword() + "', " + (this.credential.getIsAdminstrator() ? "Administrador, " : "Usuario Geral, ")
                + adressesString + ", " + telephonesString + ", Gasto total:  " + totalValue.toString() + ", "
                + buysString);
    }

}
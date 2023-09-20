package br.edu.ifnmg;

public class Adress {
    private AdressType adressType;
    private String street;
    private Integer number;
    private String district;
    private Integer cep;

    public enum AdressType {
        AVENIDA, PRACA, RUA, OUTRO
    }

    private AdressType extractLogradouro(String adress){
        String aux = adress.split(" ")[0].toUpperCase();
        switch (aux){
            case "RUA" -> {return AdressType.RUA;}
            case "AVENIDA" -> {return AdressType.AVENIDA;}
            case "PRACA" -> {return AdressType.PRACA;}
            case "OUTRO" -> {return AdressType.OUTRO;}
        };
        return AdressType.RUA;
    }

    public AdressType getAdressType() {
        return adressType;
    }

    public void setAdressType(AdressType adressType) {
        this.adressType = adressType;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws Exception {
        if (street.length() > 255) {
            throw new Exception("Excedido tamanho maximo de 255 caracteres");
        }
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) throws Exception {
        if (street.length() > 50) {
            throw new Exception("Excedido tamanho maximo de 50 caracteres");
        }
        this.district = district;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Adress(AdressType adressType, String street, Integer number, String district, Integer cep)
            throws Exception {
        setAdressType(adressType);
        setStreet(street);
        setNumber(number);
        setDistrict(district);
        setCep(cep);
    }

    @Override
    public String toString() {
        return adressType.toString() + " " + street + ", " + number + ", " + district + ", " + cep;
    }
}
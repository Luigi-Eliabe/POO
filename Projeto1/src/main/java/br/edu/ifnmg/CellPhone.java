package br.edu.ifnmg;

public class CellPhone {
    private Byte ddd;
    private Integer number;

    public Byte getDdd() {
        return ddd;
    }

    public void setDdd(Byte ddd) {
        this.ddd = ddd;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public CellPhone(Byte ddd, Integer number) {
        setDdd(ddd);
        setNumber(number);
    }

    @Override
    public String toString() {
        String numberString = Integer.toString(number);
        if (numberString.length() == 9) {
            String aux = "(" + ddd + ") " + String.format("%,d", number);
            return aux.replace(",", "-");
        }
        return "(" + ddd + ") " + numberString.substring(0, 4) + "-" + numberString.substring(4);
    }
}
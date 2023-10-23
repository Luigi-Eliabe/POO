package com.br.edu.ifnmg;

public class Utils {
    public static int ObtainDigit(long num, int pos) throws Exception {
        if (pos < 1 || pos > 9) {
            throw new Exception("Formato de digito incorreto!");
        }

        int digit = 0;
        for (int i = 1; i <= pos; i++) {
            digit = (int)(num % 10);
            num /= 10;
        }

        return digit;
    }

    public static boolean validateCpf(long cpf) {
        String strLong = Long.toString(cpf);
        return validateCpf(strLong);
    }

    public static boolean validateCpf(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) {
            return false;
        }

        boolean allEquals = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                allEquals = false;
                break;
            }
        }
        if (allEquals) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Character.getNumericValue(cpf.charAt(i));
            sum += digit * (10 - i);
        }
        int firstDigit = 11 - (sum % 11);
        if (firstDigit == 10 || firstDigit == 11) {
            firstDigit = 0;
        }
        if (firstDigit != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }

        sum = 0;
        for (int i = 0; i < 10; i++) {
            int digit = Character.getNumericValue(cpf.charAt(i));
            sum += digit * (11 - i);
        }
        int secondDigit = 11 - (sum % 11);
        if (secondDigit == 10 || secondDigit == 11) {
            secondDigit = 0;
        }
        if (secondDigit != Character.getNumericValue(cpf.charAt(10))) {
            return false;
        }

        return true;
    }
}
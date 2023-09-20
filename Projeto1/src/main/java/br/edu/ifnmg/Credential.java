package br.edu.ifnmg;

public class Credential {
    private Person person;
    private String email;
    private String password;
    private Boolean isAdminstrator;

    public Credential(String email, String password, Boolean isAdminstrator, Person person) throws Exception {
        setEmail(email);
        setPassword(password);
        setIsAdminstrator(isAdminstrator);
        setPerson(person);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        if (password.length() > 12) {
            throw new Exception("Excedido tamanho maximo de 12 caracteres");
        }
        this.password = password;
    }

    public Boolean getIsAdminstrator() {
        return isAdminstrator;
    }

    public void setIsAdminstrator(Boolean isAdminstrator) {
        if (isAdminstrator == null) {
            this.isAdminstrator = false;
            return;
        }
        this.isAdminstrator = isAdminstrator;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
            return email + ", " + "Senha: '" + password + "'" + (isAdminstrator ? ", Administrador" : ", Usuário Geral");
        }
}

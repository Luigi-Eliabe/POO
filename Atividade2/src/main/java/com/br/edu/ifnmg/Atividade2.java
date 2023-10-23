package com.br.edu.ifnmg;

import java.util.ArrayList;
import java.util.Scanner;

public class Atividade2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a Prática a ser executada: ");
        System.out.println("1 - Prática 1");
        System.out.println("2 - Prática 2");
        System.out.println("3 - Prática 3");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                int t;
                System.out.println("Quantidade de ins e outs: ");
                t = (int)scanner.nextInt();
                Double aux;
                ArrayList<Double> ins = new ArrayList<>();
                ArrayList<Double> outs = new ArrayList<>();
                for(int i=0; i<t; i++){
                    System.out.println("\nin: ");
                    aux = (Double)scanner.nextDouble();
                    ins.add(new Double(aux));
                    System.out.println("\nout: ");
                    aux = (Double)scanner.nextDouble();
                    outs.add(new Double(aux));
                }
                for(var x: ins){
                    System.out.println(x + " ");
                }

                Dupla<Double, Double> res = new Dupla();
                res = MyClass.metodo(ins, outs);

                System.out.println("w1 = " + res.getX() + " w0 = " + res.getY());
                break;
            case 2:
                System.out.println("Digite o CPF: ");
                String input = scanner.nextLine();
                if(input.equals(""))
                    input = scanner.nextLine();
                if(input.startsWith("0") || input.contains(".") || input.contains("-")){
                    if(Utils.validateCpf(input))
                        System.out.println("Válido");
                    else
                        System.out.println("Inválido");
                }
                else{
                    if(Utils.validateCpf(Long.parseLong(input)))
                        System.out.println("Válido");
                    else
                        System.out.println("Inválido");
                }
                break;
            case 3:
                System.out.println("Digite a coluna inicial: ");
                int col = scanner.nextInt();
                System.out.println("Digite a linha inicial: ");
                int row = scanner.nextInt();
                PasseioCavalo cavalo = new PasseioCavalo(row, col);
                break;
        }



    }
}

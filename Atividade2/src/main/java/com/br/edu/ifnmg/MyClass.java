package com.br.edu.ifnmg;

import java.util.ArrayList;
public class MyClass {
    public static Dupla metodo(ArrayList<Double> ins, ArrayList<Double> outs, Double lr){
        Double w0 = 0.0;
        Double w1 = 0.0;
        Double p;
        Double dif;
        Integer e = 2000;

        for (int epoch = 0; epoch < e; epoch++) {
            for (int i = 0; i < ins.size(); i++) {
                double in = ins.get(i);
                double out = outs.get(i);
                p = w1 * in + w0;
                dif = out - p;
                w0 += dif * lr;
                w1 += dif * lr * in;
                if (epoch % 10 == 0) {
                    System.out.println("Epoch: " + epoch + ", w1: " + w1 + ", w0: " + w0);
                }
            }
        }
        return new Dupla(w1,w0);
    }

    public static Dupla metodo(ArrayList<Double> ins, ArrayList<Double> outs, Integer e){
        Double w0 = 0.0;
        Double w1 = 0.0;
        Double p;
        Double dif;
        Double lr = 0.025;

        for (int epoch = 0; epoch < e; epoch++) {
            for (int i = 0; i < ins.size(); i++) {
                double in = ins.get(i);
                double out = outs.get(i);
                p = w1 * in + w0;
                dif = out - p;
                w0 += dif * lr;
                w1 += dif * lr * in;
                if (epoch % 10 == 0) {
                    System.out.println("Epoch: " + epoch + ", w1: " + w1 + ", w0: " + w0);
                }
            }
        }
        return new Dupla(w1,w0);
    }

    public static Dupla metodo(ArrayList<Double> ins, ArrayList<Double> outs){
        Double w0 = 0.0;
        Double w1 = 0.0;
        Double p;
        Double dif;
        Integer e = 2000;
        Double lr = 0.025;

        for (int epoch = 0; epoch < e; epoch++) {
            for (int i = 0; i < ins.size(); i++) {
                double in = ins.get(i);
                double out = outs.get(i);
                p = w1 * in + w0;
                dif = out - p;
                w0 += dif * lr;
                w1 += dif * lr * in;
                if (epoch % 10 == 0) {
                    System.out.println("Epoch: " + epoch + ", w1: " + w1 + ", w0: " + w0);
                }
            }
        }
        return new Dupla(w1,w0);
    }

    public static Dupla metodo(ArrayList<Double> ins, ArrayList<Double> outs, Integer e, Double lr){
        Double w0 = 0.0;
        Double w1 = 0.0;
        Double p;
        Double dif;

        for (int epoch = 0; epoch < e; epoch++) {
            for (int i = 0; i < ins.size(); i++) {
                double in = ins.get(i);
                double out = outs.get(i);
                p = w1 * in + w0;
                dif = out - p;
                w0 += dif * lr;
                w1 += dif * lr * in;
                if (epoch % 10 == 0) {
                    System.out.println("Epoch: " + epoch + ", w1: " + w1 + ", w0: " + w0);
                }
            }
        }
        return new Dupla(w1,w0);
    }
}
package com.dio;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int escolha=0;


        System.out.println("Dio, exercício JAVA - Lists");
        while(escolha != 3) {
        System.out.print("\nQual exercício quer acessar? \n 1 - Média de Temperatura \n 2 - Detetive \n 3 - Parar o programa \n Sua escolha é:");
        escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    temperaturaMedia();
                    break;
                case 2:
                    quizDetetive();
                    break;
                case 3:
                    System.out.println("\nTchauu");
                    break;
                default:
                    System.out.println("\nOpção inválida, escolha entre 1, 2 e 3.\n");
                    break;
            }
        }
    }

    public static void temperaturaMedia(){
        Scanner scan = new Scanner(System.in);
        List<Double> temp = new ArrayList<>();

        System.out.println();

        System.out.println("Programa Média de temperatura");
        System.out.println("Insira a temperatura média para cada um dos 6 meses do ano: ");

        //Aqui permitimos que o usuário dentro do limite estipulado informe temperaturas
        for(int i = 0; i < 6 ; i++) {
            System.out.print("Mês " + (i+1) +"º:");
            temp.add(i, scan.nextDouble());
        }

        //Aqui os elementos da list serão somados utilizando o iterator e um while
        Iterator<Double> IteratorTemp = temp.iterator();
        Double somaTemp = 0d;

        while(IteratorTemp.hasNext()){
            Double next = IteratorTemp.next();
            somaTemp += next;
        }

        Double mediaTemp = somaTemp/6d;
        System.out.println("A média da temperatura em relação ao período é: " + mediaTemp + "º!\n");

            for(int i = 0; i < 6; i++) {
                if (temp.get(i) > mediaTemp) {
                    System.out.println("Temperaturas acima da média (" + mediaTemp + ") por: " + (temp.get(i) - mediaTemp) + " no mês nº: " + (i + 1));
                }
            }
    }

    public static void quizDetetive(){
        Scanner scan = new Scanner(System.in);
        List<String> msg = new ArrayList<>();
        int provas = 0;

        System.out.println("\nQuiz do Detetive: \n Responda as perguntas com S(sim) ou N(não).");

        System.out.println("Telefonou para a vitima?");
        msg.add(0, scan.next());
        System.out.println("Esteve no local do crime?");
        msg.add(1, scan.next());
        System.out.println("Mora perto da vitima?");
        msg.add(2, scan.next());
        System.out.println("Devia para a vitima?");
        msg.add(3, scan.next());
        System.out.println("Já trabalhou com a vitima?");
        msg.add(4, scan.next());

        for (String s : msg) {
            if (Objects.equals(s, "s")) {
                provas += 1;
            }
        }
        if (provas == 0){
            System.out.println("Inocente");
        }
        else if(provas <= 2){
            System.out.println("Suspeito");
        }
        else if(provas <= 4){
            System.out.println("Cúmplice");
        }
        else{
            System.out.println("Assassino");
        }
    }
}

package org.bancodigital;

import org.bancodigital.model.entity.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Dev cadastrarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("DIGITE O SEU NOME: ");
        String nome = scanner.nextLine();

        return new Dev(nome);
    }

    public static List<Bootcamp> obterBootcamp() {
        List<Bootcamp> bootcampsAbertos = new ArrayList<>();

        //cria os bootcamps e os conteúdos que o compoe
        //Bootcamps
        Bootcamp bootcampJava = new Bootcamp("Java Full-stack", "Tudo Sobre Java");
        Bootcamp bootcampJs = new Bootcamp("JavaScript", "Curso para iniciantes");
        Bootcamp bootcampJsAvancado = new Bootcamp("JavaScript Avançado", "Curso Avançado");
        Bootcamp bootcampPython = new Bootcamp("Python", "Python para Ciência de Dados");

        //Conteúdos
        Conteudo cursoIntroducao = new Curso("Aula 1", "Introdução ao Bootcamp", 2);
        Conteudo curso1 = new Curso("Aula 0", "Introdução ao Bootcamp", 3);
        Conteudo curso2 = new Curso("Aula A", "conteúdo 1", 5);
        Conteudo curso3 = new Curso("Aula X", "conteúdo 2", 1);
        Conteudo curso4 = new Curso("Aula H", "conteúdo 3", 4);

        Conteudo mentoria1 = new Mentoria();
        mentoria1.setTitulo("Algoritmos");
        mentoria1.setDescricao("Aprendendo conceitos");

        Conteudo mentoria2 = new Mentoria();
        mentoria2.setTitulo("GitHub");
        mentoria2.setDescricao("Conhecendo o GitHub");

        //adicionar os conteúdos ao bootCamp
        bootcampJava.getConteudos().add(cursoIntroducao);
        bootcampJs.getConteudos().add(cursoIntroducao);
        bootcampJsAvancado.getConteudos().add(cursoIntroducao);
        bootcampPython.getConteudos().add(cursoIntroducao);

        bootcampJava.getConteudos().add(curso2);
        bootcampJava.getConteudos().add(curso3);
        bootcampJava.getConteudos().add(curso4);
        bootcampJava.getConteudos().add(mentoria2);

        bootcampJs.getConteudos().add(curso1);
        bootcampJs.getConteudos().add(curso2);
        bootcampJs.getConteudos().add(curso3);
        bootcampJs.getConteudos().add(mentoria1);

        bootcampPython.getConteudos().add(curso2);
        bootcampPython.getConteudos().add(curso4);
        bootcampPython.getConteudos().add(mentoria1);
        bootcampPython.getConteudos().add(mentoria2);

        bootcampJsAvancado.getConteudos().add(mentoria1);
        bootcampJsAvancado.getConteudos().add(mentoria2);
        bootcampJsAvancado.getConteudos().add(curso1);
        bootcampJsAvancado.getConteudos().add(curso2);
        bootcampJsAvancado.getConteudos().add(curso3);


        bootcampsAbertos.add(bootcampJava);
        bootcampsAbertos.add(bootcampJs);
        bootcampsAbertos.add(bootcampPython);
        bootcampsAbertos.add(bootcampJsAvancado);
        return bootcampsAbertos;
    }

    public static void inscreverBootcamp(Dev dev) {
        Scanner scanner =new Scanner(System.in);

        List<Bootcamp>bootcampsAbertos = obterBootcamp();

        int opcao = 0;
        do {
            System.out.println("---------------------------------------" +
                    "\nSelecione o Bootcamp.");
            int i = 1;
            for (Bootcamp b : bootcampsAbertos) {
                System.out.println("[" + i + "]" + b.getNome() + " ----- " + b.getDescricao());
                i++;
            }
            System.out.println("[5]Acessar Home");
            System.out.println("[0]voltar");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    dev.inscreverBootcamp(bootcampsAbertos.get(0));
                    System.out.println("inscrição realizada.");
                    break;
                case 2:
                    dev.inscreverBootcamp(bootcampsAbertos.get(1));
                    System.out.println("inscrição realizada.");
                    break;
                case 3:
                    dev.inscreverBootcamp(bootcampsAbertos.get(2));
                    System.out.println("inscrição realizada.");
                    break;
                case 4:
                    dev.inscreverBootcamp(bootcampsAbertos.get(3));
                    System.out.println("inscrição realizada.");
                    break;
                case 5:
                    home(dev);
                    break;
                case 0:
                    break;
            }

        } while (opcao != 0);
    }

    public static void home(Dev dev) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(dev.getNome().toUpperCase());
        int opcao = 0;
        do {
            System.out.println("------------------------------------------");
            System.out.println("Menu");
            System.out.println("[1]Listar conteúdos inscritos           [2]Listar contúdos concluídos");
            System.out.println("[3]Progredir                            [4]Exibir XP");
            System.out.println("[0]Voltar");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println(dev.getConteudosInscritos());
                    break;
                case 2:
                    System.out.println(dev.getConteudosConcluidos());
                    break;
                case 3:
                    dev.progredir();
                    break;
                case 4:
                    System.out.println("XP: " + dev.calcularXp());
                    break;
                case 5:
                    break;
            }

        }while (opcao != 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        System.out.println("----------------------------------------------");
        do {
            System.out.println("[1]Registre-se              [0]Sair");
            try{
                opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        Dev novoDev = cadastrarUsuario();
                        inscreverBootcamp(novoDev);
                        break;
                    case 0:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Dados de entrada inválidos");
                e.printStackTrace();
            }
        } while (opcao != 0);
    }
}
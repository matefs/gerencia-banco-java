package com.mycompany.gerenciabanco;
import java.util.Scanner;

public class GerenciaBanco {

    public static void main(String[] args) { 
        Banco banco = new Banco("Mateus", "11255338970", 1000.0);

        Scanner scanner = new Scanner(System.in);
        
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    banco.exibirDadosPessoais();
                    break;
                case 2:
                    banco.realizarOperacaoBancaria(scanner);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);
        
        scanner.close();
    }
    
    public static void exibirMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1 - Exibir dados pessoais");
        System.out.println("2 - Realizar operação bancária");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }
}


class Banco {
    private String nome;
    private String cpf;
    private double saldo;
    
    // Construtor que recebe parâmetros
    public Banco(String nome, String cpf, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
    }
    
    public void exibirDadosPessoais() {
        System.out.println("\n");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Saldo: R$" + saldo + "\n");
    }
    
    public void realizarOperacaoBancaria(Scanner scanner) {
        System.out.println("\n === Operações Bancárias ===");
        System.out.println("1 - Consultar saldo");
        System.out.println("2 - Depositar");
        System.out.println("3 - Retirar");
        System.out.println("4 - Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
        
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1:
                consultarSaldo();
                break;
            case 2:
                depositar(scanner);
                break;
            case 3:
                retirar(scanner);
                break;
            case 4:
                System.out.println("Voltando ao menu principal... \n");
                break;
            default:
                System.out.println("Opção inválida! Tente novamente. \n");
        }
    }
    
    private void consultarSaldo() {
        System.out.println("Saldo atual: R$" + saldo + "\n\n");
    }
    
    private void depositar(Scanner scanner) {
        System.out.print("Digite o valor a ser depositado: R$");
        double valor = scanner.nextDouble();
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso! \n\n");
        } else {
            System.out.println("Valor inválido! O valor a ser depositado deve ser maior que zero. \n\n");
        }
    }
    
    private void retirar(Scanner scanner) {
        System.out.print("Digite o valor a ser retirado: R$");
        double valor = scanner.nextDouble();
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Retirada realizada com sucesso! \n");
        } else {
            System.out.println("Valor inválido! Verifique o saldo disponível ou o valor inserido. \n");
        }
    }
}

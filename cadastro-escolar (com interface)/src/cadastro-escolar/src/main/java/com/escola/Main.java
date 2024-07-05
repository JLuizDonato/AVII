package com.escola;

import java.util.List;
import java.util.Scanner;

import com.escola.dao.AlunoDAO;
import com.escola.model.Aluno;

public class Main {
    private static AlunoDAO alunoDAO = new AlunoDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Inserir Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Listar Alunos por Nome Inicial");
            System.out.println("4. Alterar Aluno");
            System.out.println("5. Remover Aluno");
            System.out.println("6. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1:
                    inserirAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    listarAlunosPorNomeInicial();
                    break;
                case 4:
                    alterarAluno();
                    break;
                case 5:
                    removerAluno();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void inserirAluno() {
        Aluno aluno = new Aluno();
        System.out.println("Digite o nome do aluno:");
        aluno.setNome(scanner.nextLine());
        System.out.println("Digite o email do aluno:");
        aluno.setEmail(scanner.nextLine());
        System.out.println("Digite o CPF do aluno:");
        aluno.setCpf(scanner.nextLine());
        System.out.println("Digite a data de nascimento do aluno (yyyy-MM-dd):");
        aluno.setDataNascimento(java.sql.Date.valueOf(scanner.nextLine()));
        System.out.println("Digite a naturalidade do aluno:");
        aluno.setNaturalidade(scanner.nextLine());
        System.out.println("Digite o endereço do aluno:");
        aluno.setEndereco(scanner.nextLine());

        alunoDAO.inserir(aluno);
        System.out.println("Aluno inserido com sucesso!");
    }

    private static void listarAlunos() {
        List<Aluno> alunos = alunoDAO.listar();
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private static void listarAlunosPorNomeInicial() {
        System.out.println("Digite a letra inicial do nome:");
        String inicial = scanner.nextLine();
        List<Aluno> alunos = alunoDAO.listarPorNomeInicial(inicial);
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private static void alterarAluno() {
        System.out.println("Digite o ID do aluno a ser alterado:");
        Long id = scanner.nextLong();
        scanner.nextLine();  // Consumir a nova linha

        Aluno aluno = alunoDAO.listar().stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }

        System.out.println("Digite o novo nome do aluno:");
        aluno.setNome(scanner.nextLine());
        System.out.println("Digite o novo email do aluno:");
        aluno.setEmail(scanner.nextLine());
        System.out.println("Digite o novo CPF do aluno:");
        aluno.setCpf(scanner.nextLine());
        System.out.println("Digite a nova data de nascimento do aluno (yyyy-MM-dd):");
        aluno.setDataNascimento(java.sql.Date.valueOf(scanner.nextLine()));
        System.out.println("Digite a nova naturalidade do aluno:");
        aluno.setNaturalidade(scanner.nextLine());
        System.out.println("Digite o novo endereço do aluno:");
        aluno.setEndereco(scanner.nextLine());

        alunoDAO.alterar(aluno);
        System.out.println("Aluno alterado com sucesso!");
    }

    private static void removerAluno() {
        System.out.println("Digite o ID do aluno a ser removido:");
        Long id = scanner.nextLong();
        scanner.nextLine();  // Consumir a nova linha

        alunoDAO.remover(id);
        System.out.println("Aluno removido com sucesso!");
    }
}

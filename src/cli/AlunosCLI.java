package cli;

import java.util.Scanner;

import dao.AlunoDao;
import entidades.Aluno;

public class AlunosCLI {
    private static AlunoDao alunoDB = new AlunoDao();
    private static final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        System.out.println("Bem-vindo ao gerenciador de alunos!");

        boolean continuar = true;
        while (continuar) {
            exibirOpcoes();
            String opcao = lerTexto();
            continuar = processarOpcoes(opcao);
        }

        alunoDB.salvarDados();
    }

    private void exibirOpcoes() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Listar alunos");
        System.out.println("2 - Adicionar aluno");
        System.out.println("3 - Editar aluno");
        System.out.println("4 - Remover aluno");
        System.out.println("5 - Sair");
        System.out.print("Opção: ");
    }

    private boolean processarOpcoes(String opcao) {
        switch (opcao) {
            case "1":
                listarAlunos();
                break;
            case "2":
                adicionarAluno();
                break;
            case "3":
                editarAluno();
                break;
            case "4":
                removerAluno();
                break;
            case "5":
                return false;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
        return true;
    }

    private void listarAlunos() {
        System.out.println("\nLista de alunos:");
        for (Aluno aluno : alunoDB.listarTodosAlunos().values()) {
            System.out.println("Nome: " + aluno.getNome() + " - Curso: " + aluno.getCurso() + " - Matrícula: "
                    + aluno.getMatricula());
        }
    }

    private void adicionarAluno() {
        System.out.println("Informe o nome do aluno:");
        String nome = lerTexto();
        System.out.println("Informe o curso do aluno:");
        String curso = lerTexto();
        System.out.println("Informe a matrícula do aluno:");
        String matricula = lerTexto();

        Aluno novoAluno = new Aluno(nome, curso, matricula);
        alunoDB.adicionarAluno(novoAluno);
        System.out.println("Aluno adicionado com sucesso!");
    }

    private void editarAluno() {
        System.out.println("Informe a matrícula do aluno que deseja editar:");
        String matricula = lerTexto();
        Aluno aluno = alunoDB.recuperarAluno(matricula);
        if (aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        System.out.println("Informe o novo curso para o aluno:");
        String novoCurso = lerTexto();
        alunoDB.atualizarCurso(matricula, novoCurso);
        System.out.println("Curso do aluno atualizado com sucesso!");
    }

    private void removerAluno() {
        System.out.println("Informe a matrícula do aluno que deseja remover:");
        String matricula = lerTexto();
        alunoDB.removerAluno(matricula);
        System.out.println("Aluno removido com sucesso!");
    }

    private String lerTexto() {
        return scanner.nextLine();
    }

    public void fecharScanner() {
        scanner.close();
    }

}

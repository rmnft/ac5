package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import entidades.Aluno;

public class AlunoDao {
    private HashMap<String, Aluno> alunos = new HashMap<>();
    private static final String ARQUIVO_DADOS = "alunos.txt";

    public void adicionarAluno(Aluno aluno) {
        alunos.put(aluno.getMatricula(), aluno);
    }

    public Aluno removerAluno(String matricula) {
        return alunos.remove(matricula);
    }

    public void atualizarCurso(String matricula, String novoCurso) {
        Aluno aluno = alunos.get(matricula);
        aluno.setCurso(novoCurso);
    }

    public Aluno recuperarAluno(String matricula) {
        return alunos.get(matricula);
    }

    public HashMap<String, Aluno> listarTodosAlunos() {
        return alunos;
    }

    private String arquivoDados = "alunos.txt";

    public AlunoDao() {
        carregarDados();
    }

    private void carregarDados() {
        File arquivo = new File(arquivoDados);
        if (arquivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivoDados))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] dados = line.split(","); // Supondo que os dados estejam separados por vírgula
                    adicionarAluno(new Aluno(dados[0], dados[1], dados[2]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoDados))) {
            for (Aluno aluno : alunos.values()) {
                writer.write(aluno.getNome() + "," + aluno.getCurso() + "," + aluno.getMatricula());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
package dao;

import java.util.HashMap;

import entidades.Aluno;

public class AlunoDao {
    private HashMap<String, Aluno> alunos = new HashMap<>();

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

}
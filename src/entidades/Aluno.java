package entidades;

public class Aluno {
    private String nome;
    private String curso;
    private String matricula;

    public Aluno(String nome, String curso, String matricula) {
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}

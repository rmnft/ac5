import dao.AlunoDao;
import entidades.Aluno;

public class App {
    public static void main(String[] args) throws Exception {
        AlunoDao alunos = new AlunoDao();

        alunos.adicionarAluno(new Aluno("Raphael", "Artista", "1234"));
        alunos.adicionarAluno(new Aluno("Larissa", "Modelo", "5678"));
        alunos.adicionarAluno(new Aluno("Mayla", "Princesa", "1122"));

        alunos.removerAluno("1234");

        System.out.println(alunos);
        System.out.println(alunos.recuperarAluno("1234"));
        System.out.println(alunos.recuperarAluno("5678"));

        alunos.atualizarCurso("5678", "Empresária");

        for (Aluno aluno : alunos.listarTodosAlunos().values()) {
            System.out.println("Nome: " + aluno.getNome() + ", Curso: " + aluno.getCurso() + ", Matrícula: "
                    + aluno.getMatricula());
        }

    }

}

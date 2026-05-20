/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.universidade.poo.biblioteca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *  @author António Neves José
 */
public class Aluno {

    private String nome;
    private String numeroMatricula;
    private String curso;

    private List<Emprestimo> emprestimos = new ArrayList<>();
    private static final int MAX_EMPRESTIMOS = 3;

    public Aluno(String nome, String numeroMatricula, String curso) {

        setNome(nome);
        setNumeroMatricula(numeroMatricula);
        setCurso(curso);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome == null || nome.isBlank()) {

            throw new IllegalArgumentException("Nome inválido");
        }

        this.nome = nome;
    }

    public String getNumeroMatricula() {

        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {

        if (numeroMatricula == null ||numeroMatricula.isBlank()) {

            throw new IllegalArgumentException( "Matrícula inválida");
        }

        this.numeroMatricula = numeroMatricula;
    }

    public String getCurso() {

        return curso;
    }

    public void setCurso(String curso) {

        if (curso == null) {

            curso = "";
        }

        this.curso = curso;
    }

    public List<Emprestimo> getEmprestimos() {

        return new ArrayList<>(
                emprestimos
        );
    }

        public boolean emprestarLivro(Livro livro) {

        if (livro == null) {

            throw new IllegalArgumentException( "Livro nulo");
        }

        if (emprestimos.size()>= MAX_EMPRESTIMOS) {

            System.out.println("Limite de empréstimos atingido");

            return false;
        }

        if (!livro.emprestar()) {

            return false;
        }

        Emprestimo e = new Emprestimo( livro,7);

        emprestimos.add(e);

        return true;
    }

      public boolean devolverLivro(Livro livro) {

        for (Emprestimo e : emprestimos) {

            if (e.getLivro().equals(livro)) {

                emprestimos.remove(e);

                livro.devolver();

                return true;
            }
        }

        return false;
    }

    public String mostrarEmprestimos() {

        if (emprestimos.isEmpty()) {

            return nome + " não possui empréstimos.";
        }

        StringBuilder sb = new StringBuilder( nome + " possui:\n");

        for (Emprestimo e : emprestimos) {

            sb.append(" - ").append(e.info()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {

        return nome +" (" + numeroMatricula + ") - " + curso;
    }
}

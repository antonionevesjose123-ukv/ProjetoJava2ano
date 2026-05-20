/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.universidade.poo.biblioteca;

/**
 *
 * @author António Neves José
 */

public class Livro {

    private String titulo;
    private String autor;
    private String isbn;

    private int copiasDisponiveis;

    public Livro(String titulo,
                 String autor,
                 String isbn,
                 int copiasDisponiveis) {

        setTitulo(titulo);
        setAutor(autor);
        setIsbn(isbn);

        if (copiasDisponiveis < 0) {

            throw new IllegalArgumentException( "Número de cópias inválido" );
        }

        this.copiasDisponiveis = copiasDisponiveis;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {

        if (titulo == null ||titulo.isBlank()) {

            throw new IllegalArgumentException( "Título inválido");
        }

        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {

        if (autor == null ||autor.isBlank()) {

            throw new IllegalArgumentException("Autor inválido");
        }

        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {

        if (isbn == null ||!isbn.matches("\\d{13}")) {

            throw new IllegalArgumentException("ISBN inválido");
        }

        this.isbn = isbn;
    }

    public int getCopiasDisponiveis() {

        return copiasDisponiveis;
    }

       public boolean isDisponivel() {

        return copiasDisponiveis > 0;
    }

     public boolean emprestar() {

        if (!isDisponivel()) {

            return false;
        }

        copiasDisponiveis--;

        return true;
    }

  
    public void devolver() {

        copiasDisponiveis++;
    }

    public String info() {

        return String.format( "%s - %s (ISBN: %s) | Cópias disponíveis: %d",
                titulo,
                autor,
                isbn,
                copiasDisponiveis );
    }

    @Override
    public String toString() {

        return info();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.universidade.poo.biblioteca;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author António Neves José
 */
public class Biblioteca {

    private List<Livro> catalogo = new ArrayList<>();

    public void adicionarLivro( Livro livro) {

        catalogo.add(livro);
    }

        public Livro buscarPorTitulo( String titulo) {

        for (Livro l : catalogo) {

            if (l.getTitulo().equalsIgnoreCase( titulo)) {

                return l;
            }
        }

        return null;
    }

    public Livro buscarPorIsbn(String isbn) {

        for (Livro l : catalogo) {

            if (l.getIsbn().equals(isbn)) {

                return l;
            }
        }

        return null;
    }

      public List<Livro> buscarPorAutor(String autor) {

        List<Livro> resultado =
                new ArrayList<>();

        for (Livro l : catalogo) {

            if (l.getAutor().equalsIgnoreCase(autor)) {

                resultado.add(l);
            }
        }

        return resultado;
    }

    public List<Livro> getCatalogo() {

        return catalogo;
    }

    public void mostrarCatalogo() {

        for (Livro l : catalogo) {

            System.out.println(
                    l.info()
            );
        }
    }
}

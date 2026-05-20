/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ao.universidade.poo.biblioteca;
import ao.universidade.poo.biblioteca.BibliotecaGson.Json;

/**
 *
 * @author António Neves José
 */
    public class BibliotecaAPP {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Livro l1 = new Livro( "Introdução a Java", "Ana Silva", "9781234567890",2);

        Livro l2 = new Livro( "Estruturas de Dados", "Carlos Souza", "9780987654321",1);

        biblioteca.adicionarLivro(l1);
        biblioteca.adicionarLivro(l2);

        Aluno a1 = new Aluno( "João Pereira", "2023001","Engenharia Informática");

        System.out.println("=== CATÁLOGO ===");

        biblioteca.mostrarCatalogo();

        System.out.println();

        boolean sucesso = a1.emprestarLivro(l1);

        System.out.println("Empréstimo realizado? " + sucesso);

        System.out.println( a1.mostrarEmprestimos());
 
        BibliotecaGson.salvar( biblioteca, "biblioteca.json");
    }
}
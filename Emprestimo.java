/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.universidade.poo.biblioteca;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author António Neves José
 */


public class Emprestimo {

    private Livro livro;
    private LocalDate dataEmpres;
    private LocalDate dataDevolu;

    private static final double MULTA_POR_DIA = 500;

    public Emprestimo(Livro livro, int Prazo) {

        this.livro = livro;
        this.dataEmpres = LocalDate.now();
        this.dataDevolu = dataEmpres.plusDays(Prazo);
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmpres() {
        return dataEmpres;
    }

    public LocalDate getDataDevolu() {
        return dataDevolu;
    }

    public boolean Atrasounaentrega() {
        return LocalDate.now().isAfter(dataDevolu);
    }

    public long calcularDiasAtraso() {

        if (!Atrasounaentrega()) {
            return 0;
        }

        return ChronoUnit.DAYS.between( dataDevolu, LocalDate.now());
    }

    public double calcularMulta() {

        return calcularDiasAtraso() * MULTA_POR_DIA;
    }

    public String info() {

        return String.format(
                "%s | Emprestado: %s | Prazo: %s | Atrasado: %s | Multa: %.2f KZ",
                livro.getTitulo(),
                dataEmpres,
                dataDevolu,
                Atrasounaentrega() ? "Sim" : "Não", calcularMulta());
    }
}
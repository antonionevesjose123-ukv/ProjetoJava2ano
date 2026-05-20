/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.universidade.poo.banco;

/**
 *
 *@author António Neves José
 */

public class ContaPoupanca extends Conta {

    private double taxaRendimento;

    public ContaPoupanca(String numero,double saldoInicial,double taxaRendimento) {

        super(numero, saldoInicial);

        if (taxaRendimento < 0) {
            throw new IllegalArgumentException("Taxa inválida");
        }

        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {

        if (taxaRendimento < 0) {
            throw new IllegalArgumentException("Taxa inválida");
        }

        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento() {
        saldo += saldo * taxaRendimento;
    }

    @Override
    public String toString() {
        return "ContaPoupanca " + numero + " - Saldo: " + saldo + " - Taxa: " + taxaRendimento;
    }
}
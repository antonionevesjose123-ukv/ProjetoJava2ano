/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.universidade.poo.banco;

/**
 *
 * @author António Neves José
 */
public class Conta {

    protected String numero;
    protected double saldo;

    public Conta(String numero, double saldoInicial) {

        if (numero == null || numero.isBlank()) {
            throw new IllegalArgumentException("Número inválido");
        }

        if (saldoInicial < 0) {
            throw new IllegalArgumentException("Saldo inicial inválido");
        }

        this.numero = numero;
        this.saldo = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {

        if (valor <= 0) {
            throw new IllegalArgumentException("Depósito deve ser positivo");
        }

        saldo += valor;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {

        if (valor <= 0) {
            throw new IllegalArgumentException("Saque deve ser positivo");
        }

        if (saldo < valor) {
            throw new SaldoInsuficienteException( "Saldo insuficiente: saldo=" + saldo + ", valor=" + valor );
        }

        saldo -= valor;
    }

    public void transferir(Conta destino, double valor)
            throws SaldoInsuficienteException {

        if (destino == null) {
            throw new IllegalArgumentException("Conta destino nula");
        }

        this.sacar(valor);
        destino.depositar(valor);
    }

    @Override
    public String toString() {
        return "Conta " + numero + " - Saldo: " + saldo;
    }
}
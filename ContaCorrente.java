/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.universidade.poo.banco;

/**
 *
 * @author Matondo Mauricio
 */

public class ContaCorrente extends Conta {

    private double limite;

    public ContaCorrente(String numero,double saldoInicial, double limite) {

        super(numero, saldoInicial);

        if (limite < 0) {
            throw new IllegalArgumentException("Limite inválido");
        }

        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {

        if (limite < 0) {
            throw new IllegalArgumentException("Limite inválido");
        }

        this.limite = limite;
    }

    @Override
    public void sacar(double valor)
            throws SaldoInsuficienteException {

        if (valor <= 0) {
            throw new IllegalArgumentException("Saque deve ser positivo");
        }

        if (saldo + limite < valor) {
            throw new SaldoInsuficienteException( "Saldo + limite insuficiente: saldo=" + saldo + ", limite=" + limite + ", valor=" + valor);
        }

        saldo -= valor;
    }

    @Override
    public String toString() {
        return "ContaCorrente " + numero +" - Saldo: " + saldo +" - Limite: " + limite;
    }
}
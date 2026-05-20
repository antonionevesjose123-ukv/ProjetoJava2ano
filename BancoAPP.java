/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ao.universidade.poo.banco;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author António Neves José
 */
public class BancoAPP {


    public static void main(String[] args) {

        List<Conta> contas = new ArrayList<>();

        ContaCorrente cc1 = new ContaCorrente("001", 500.0, 300.0);
        ContaPoupanca cp1 = new ContaPoupanca("002", 1000.0, 0.01);

        contas.add(cc1);
        contas.add(cp1);

        System.out.println("=== ESTADO INICIAL ===");
        imprimir(contas);

        System.out.println("\n=== DEPÓSITO EM TODAS ===");
        for (Conta c : contas) {
            c.depositar(200.0);
        }
        imprimir(contas);

        System.out.println("\n=== SAQUE COM POLIMORFISMO ===");
        try {
            cc1.sacar(1000.0);
            System.out.println("Saque OK");
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
        imprimir(contas);

        System.out.println("\n=== TRANSFERÊNCIA ===");
        try {
            cp1.transferir(cc1, 300.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
        imprimir(contas);

        System.out.println("\n=== RENDIMENTO (instanceof) ===");
        for (Conta c : contas) {
            if (c instanceof ContaPoupanca) {
                ((ContaPoupanca) c).aplicarRendimento();
            }
        }
        imprimir(contas);
    }

    private static void imprimir(List<Conta> contas) {
        for (Conta c : contas) {
            System.out.println(c);
        }
    }
}
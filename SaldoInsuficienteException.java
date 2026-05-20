/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ao.universidade.poo.banco;

/**
 *
 * @author Matondo Maurício
 */

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(String mensagem) {
        super(mensagem);
    }
}
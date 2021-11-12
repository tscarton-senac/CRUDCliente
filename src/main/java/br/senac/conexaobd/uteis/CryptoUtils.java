/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.conexaobd.uteis;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 *
 * @author tiago.bscarton
 */
public class CryptoUtils {
    
    public static String gerarHashSenha(String senhaAberta) {
        return BCrypt.withDefaults().hashToString(8, senhaAberta.toCharArray());
    }
    
    public static boolean verificarSenha(String senhaAberta, String senhaFechada){
        BCrypt.Result resultado = BCrypt.verifyer().verify(senhaAberta.toCharArray(), senhaFechada);
        return resultado.verified;
    }
    
    public static void main(String[] args) {
        String senha = "1234";
        System.out.println(gerarHashSenha(senha));
    }
}

                                        
package Metodos;

import Classes.Conta;
import Repositorios.Conta_Repositorio;

/** Login
 * Possui a função relacionada ao login do usuario
 * @author Guillermo1
 */
public class Login {
    String nome;
    private static Conta conta;  
    /** Logar_Conta
     * O que faz:Faz o login do usuário;
     * Como funciona:Se o resultado do método "Verificar_Conta()" for nulo, mostra a mensagem
     * "Conta não existe." e retorna o resultado, se o resultado for algo, mostra a mensagem
     * "Login com sucesso!" e retorna a conta encontrada;
     * @param nome nome do usuario
     * @return conta encontrada pela verificação  
     */
    public static Conta Logar_Conta(String nome){
        conta = Conta_Repositorio.getConta(nome);
        if(conta == null){
            System.out.println("Conta não existe.");
            return conta;
        }else{
            System.out.println("Login com sucesso!");
            return conta;
        }
    }
    
}
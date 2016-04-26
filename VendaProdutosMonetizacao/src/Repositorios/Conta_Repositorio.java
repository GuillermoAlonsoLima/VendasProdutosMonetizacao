package Repositorios;

import Classes.Conta;
import java.util.ArrayList;
/** Conta_Repositorio
 * Onde as contas são regisradas
 * @author Guillermo1
 */
public class Conta_Repositorio {
    private static final ArrayList<Conta> conta_repositorio = new ArrayList<>();

    /** getConta_repositorio
     * Retorna as contas cadastradas
     * @return Retorna os clientes cadastrados
     */
    public static ArrayList<Conta> getConta_repositorio() {
        return conta_repositorio;
    }
    
    /** addConta
     * adiciona conta
     * @param conta adiciona conta ao "conta_repositorio"
     */
    public static void addConta(Conta conta){
        conta_repositorio.add(conta);
    }
    
    /** delConta
     * deleta conta
     * @param conta deleta conta do "conta_repositorio"
     */
    public static void delConta(Conta conta){
        conta_repositorio.remove(conta);
    }
    
    /** getConta
     * retorna a conta procurada 
     * @param nome
     * @return conta encontrada
     */
    public static Conta getConta(String nome){
        for (Conta c : conta_repositorio) {
            if(c.getUsuario().equals(nome)){
                return c;
            }
        }
        return null;
    }
    
}
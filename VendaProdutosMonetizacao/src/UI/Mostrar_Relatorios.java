package UI;

import Classes.Conta;
import Classes.Produto;
import java.util.ArrayList;

/** Mostrar_Relatorios
 * possui métodos que transformam os dados dos relatorios em algo visível
 * @author Guillermo1
 */
public class Mostrar_Relatorios {
     
    /** Mostrar_Produtos
     * Mostra os nomes dos produtos comprados ou vendidos pelo usuario
     * @param produtos lista de produtos comprados ou vendidos pelo usuario
     */
    public static void Mostrar_Produtos(ArrayList<Produto> produtos){
        if(produtos.isEmpty()){
            System.out.println("Não há nenhuma compra ou venda efetuada!");
        }
        for(Produto p : produtos){
            System.out.println(p.getNome());
        }
    }
    
    /** Mostrar_Clientes
     * Mostra as contas que mais venderam, compraram ou efetuaram processos de monetização
     * @param contas conta destacada em uma das operações acima
     */
    public static void Mostrar_Clientes(ArrayList<Conta> contas){
        if(contas.isEmpty()){
            System.out.println("Não há nenhuma operação de monetização efetuada!");
        }else{
            for(Conta c : contas){
                System.out.println(c.getUsuario());
            }
        }
    }
}

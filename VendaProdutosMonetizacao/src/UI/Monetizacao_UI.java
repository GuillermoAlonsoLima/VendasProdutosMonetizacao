
package UI;

import Classes.Conta;
import Classes.Produto;
import Metodos.Creditacao;
import Repositorios.Produto_Repositorio;
import util.Console;

/** Monetizacao_UI
 * possui as interfaces relacionadas aos produtos, as vendas e as operações de monetização 
 * @author Guillermo1
 */
public class Monetizacao_UI {
    
    /** Cadastrar_Produto
     * Cadastra produto 
     * @param conta conta da dono deste produto
     */
    public static void Cadastrar_Produto(Conta conta){
        String nome = Console.scanString("Digite o nome do produto:");
        double preco = Double.parseDouble(Console.scanString("Digite o preço do produto:"));
        Produto_Repositorio.addProduto(new Produto(nome,preco,conta));
    }
    
    /** Comprar_Produto
     * Compra produto
     * @param conta conta do comprador
     */
    public static void Comprar_Produto(Conta conta){
        String nome = Console.scanString("Digite o nome do produto que deseja comprar:");
        Creditacao.Compra(conta, nome);
    }
    
    /** Depositar
     * Deposita dinheiro na conta
     * @param conta conta que terá dinheiro depositado
     */
    public static void Depositar(Conta conta){
        double deposito = Double.parseDouble(Console.scanString("Digite o valor que deseja depositar:"));
        Creditacao.Deposito(conta, deposito);
    }
    
    /** Transferir_Outro
     * Transfere dinheiro da conta logada a outro
     * @param conta conta do transferidor
     */
    public static void Transferir_Outro(Conta conta){
        String nome = Console.scanString("Digite o usuario da conta que deseja transferir:");
        double transferencia = Double.parseDouble(Console.scanString("Digite o valor da transferencia:"));
        Creditacao.Transferencia_Outro(conta, nome, transferencia);
    }
    
    /** Transferir_Mesmo
     * Transfere dinheiro de outra conta para a logada
     * @param conta conta do transferido
     */
    public static void Transferir_Mesmo(Conta conta){
        String nome = Console.scanString("Digite o usuario da conta que deseja receber transferencia:");
        double transferencia = Double.parseDouble(Console.scanString("Digite o valor da transferencia:"));
        Creditacao.Transferencia_Mesmo(conta, nome, transferencia);
    }
    
}
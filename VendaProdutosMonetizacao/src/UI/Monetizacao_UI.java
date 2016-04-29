
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
     */
    public static void Cadastrar_Produto(){
        try{
            String nome = Console.scanString("Digite o nome do produto:");
            if(nome.isEmpty()){
                System.out.println("O nome está vazio!");
            }else{
                double preco = Double.parseDouble(Console.scanString("Digite o preço do produto:"));
                Produto_Repositorio.addProduto(new Produto(nome,preco));
            }
        }catch(NumberFormatException e){
            System.out.println("O preço está vazio");
        }
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
        try{
            double deposito = Double.parseDouble(Console.scanString("Digite o valor que deseja depositar:"));
            Creditacao.Deposito(conta, deposito);
        }catch(NumberFormatException e){
            System.out.println("O preço está vazio");
        }
    }
    
    /** Retirar
     * Retira dinheiro da conta
     * @param conta conta que terá dinheiro retirado
     */
    public static void Retirar(Conta conta){
        try{
            double retiro = Double.parseDouble(Console.scanString("Digite o valor que deseja retirar:"));
            Creditacao.Retiro(conta, retiro);
        }catch(NumberFormatException e){
            System.out.println("O preço está vazio");
        }
    }
    
    /** Transferir_Outro
     * Transfere dinheiro da conta logada a outro
     * @param conta conta do transferidor
     */
    public static void Transferir_Outro(Conta conta){
        try{
            String nome = Console.scanString("Digite o usuario da conta que deseja transferir:");
            if(nome.isEmpty()){
                System.out.println("O nome stá vazio!");
            }else{
                double transferencia = Double.parseDouble(Console.scanString("Digite o valor da transferencia:"));
                Creditacao.Transferencia_Outro(conta, nome, transferencia);
            }
        }catch(NumberFormatException e){
            System.out.println("O preço está vazio");
        }
    }
    
    /** Transferir_Mesmo
     * Transfere dinheiro de outra conta para a logada
     * @param conta conta do transferido
     */
    public static void Transferir_Mesmo(Conta conta){
        try{
            String nome = Console.scanString("Digite o usuario da conta que deseja receber transferencia:");
            if(nome.isEmpty()){
                    System.out.println("O nome stá vazio!");
            }else{
                double transferencia = Double.parseDouble(Console.scanString("Digite o valor da transferencia:"));
                Creditacao.Transferencia_Mesmo(conta, nome, transferencia);
            }
        }catch(NumberFormatException e){
            System.out.println("O preço está vazio");
        }
    }
    
}
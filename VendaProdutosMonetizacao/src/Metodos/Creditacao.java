package Metodos;

import Classes.Conta;
import Classes.Produto;
import Classes.Venda;
import Repositorios.Conta_Repositorio;
import Repositorios.Produto_Repositorio;
import Repositorios.Venda_Repositorio;

/** Creditacao
 * Possui as funções relacionadas a monetização como depósito e transferência de dinheiro, compra e venda de produtos
 * @author Guillermo1
 */
public class Creditacao {
    private static Conta transferidor;
    /** Deposito
     * O que faz:Deposita dinheiro no saldo da conta selecionada;   
     * Como funciona:Configura-se o saldo da conta como a soma do deposito inserido 
     * e o valor do saldo atual;
     * @param conta conta que deseja depositar
     * @param deposito quantidade que deseja depositar
     */
    public static void Deposito(Conta conta,double deposito){
        conta.Depositar(deposito);
        conta.setQtd_monetizacao();
    } 
    
    /** Retiro
     * Retira dinheiro da conta
     * @param conta conta que terá dinheiro retirado
     * @param retiro quantidade que deseja retirar 
     */
    public static void Retiro(Conta conta,double retiro){
        conta.Retirar(retiro);
        conta.setQtd_monetizacao();
    }

    /** Compra
     * O que faz:Transfere o valor correspondente ao produto do comprador ao vendedor; 
     * Como funciona:Primeiro verifica-se se o produto existe,depois de confirmado,Se o saldo do cliente 
     * for inferior ao debito não será possível efetivar transferencia,se não, o debito será adicionado 
     * ao saldo do vendedor e retirado do saldo do comprador;Cada vez que falhar, terminar-se-a a venda 
     * cadastrando-a se alguma compra foi feita,se não se adicionará o produto comprado a vena a se cadastrar;
     * @param conta_comprador conta do usuario que quer comprar o produto
     * @param nome_produto o nome do produto que deseja comprar
     */
    public static void Compra(Conta conta_comprador,String nome_produto){
        Produto produto = Produto_Repositorio.getProduto(nome_produto);
        if(produto == null){
            System.out.println("O produto não existe!");
        }else{
            double debito = produto.getPreco();
            if(conta_comprador.getSaldo()<debito){
                System.out.println("Não há credito o suficiente para terminar transferência!");
            }else{
                conta_comprador.Depositar(debito);
                Venda_Repositorio.addVenda(new Venda(conta_comprador,produto));
                Produto_Repositorio.delProduto(produto);
                conta_comprador.setQtd_compras();
                System.out.println("Compra efetuada com sucesso!");
            }
        }
    }

    /** Transferencia_Outro
     * O que faz: Transfere o valor da conta atual para outra; 
     * Como funciona:Se o saldo do cliente for inferior ao valor a transferir não será possível 
     * efetivar transferencia,se não, o valor a transferir será adicionado ao saldo da outra conta
     * e retirado do saldo desta conta;
     * @param transferidor conta do usuario que deseja transferir
     * @param transferido_nome nome da conta do usuario que quer receber a transferência
     * @param transferencia quantidade a se transferir
     */
    public static void Transferencia_Outro(Conta transferidor,String transferido_nome,double transferencia){
        Conta transferido = Conta_Repositorio.getConta(transferido_nome);
        if(transferido==null){
            System.out.println("A conta que quer transferir não existe");
        }else if(transferido.getCliente()!=transferidor.getCliente()){
            System.out.println("A conta que quer transferir não é sua.");
        }else{
            if(transferidor.getSaldo()<transferencia){
                System.out.println("Não há credito o suficiente para terminar transferência!");
            }else{
                transferidor.Retirar(transferencia);
                transferido.Depositar(transferencia);
                transferidor.setQtd_monetizacao();transferido.setQtd_monetizacao();
            }
        }
    }
    
    /** Transferencia_Mesmo
     * O que faz: Transfere o valor de outra conta para a atual; 
     * Como funciona:Se o saldo do cliente for inferior ao valor a transferir não será possível 
     * efetivar transferencia,se não, o valor a transferir será adicionado ao saldo da outra conta
     * e retirado do saldo desta conta;
     * @param transferido conta do usuario que quer receber a transferência
     * @param transferidor_nome nome da conta do usuario que deseja transferir
     * @param transferencia quantidade a se transferir
     */
    public static void Transferencia_Mesmo(Conta transferido,String transferidor_nome,double transferencia){
        transferidor = Conta_Repositorio.getConta(transferidor_nome);
        if(transferidor==null){
            System.out.println("A conta que quer transferir não existe.");
        }else if(transferido.getCliente()!=transferidor.getCliente()){
            System.out.println("A conta que quer transferir não é sua.");
        }else{
            if(transferidor.getSaldo()<transferencia){
                System.out.println("Não há credito o suficiente para terminar transferência!");
            }else{
                transferidor.Retirar(transferencia);
                transferido.Depositar(transferencia);
                transferidor.setQtd_monetizacao();transferido.setQtd_monetizacao();
            }
        }
    }
    
    /** Visualizar_Saldo
     * O que faz:Mostra o saldo atual; 
     * Como funciona:Imprime o saldo atual no console;
     * @param conta conta que tera seu saldo visualizado
     */
    public static void Visualizar_Saldo(Conta conta){
        System.out.println("Saldo da conta:"+conta.getSaldo());
    }

}
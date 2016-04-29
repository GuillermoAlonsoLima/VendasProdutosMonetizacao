package Menus;

import Classes.Conta;
import Metodos.Creditacao;
import Metodos.Relatorio;
import UI.Conta_UI;
import UI.Monetizacao_UI;
import UI.Mostrar_Relatorios;
import java.util.InputMismatchException;
import util.Console;

/** Menus
 * Possui os menus de seleção
 * @author Guillermo1
 */
public class Menus {
  
    static int opcao = 0;
    
    /** Menu_Inicial
     * Menu inicial
     */
    public static void Menu_Inicial(){
        boolean teste = true;
        Conta conta;   
        while(teste == true){            
            System.out.println("-------------------------------\n"
                    + "1-Cadastrar Cliente\n"
                    + "2-Logar Conta\n"
                    + "3-Cadastrar produtos\n"
                    + "4-Sair\n"
                    + "-------------------------------"
            );
            try{                
                opcao = Console.scanInt("Digite a opção que deseja:");
                switch(opcao){
                    case 1:Conta_UI.Cadastrar_Cliente();break;
                    case 2:                        
                        conta = Conta_UI.Logar_Conta();
                        if(conta != null)
                            Menu_Login(conta);
                        break;
                    case 3:Monetizacao_UI.Cadastrar_Produto();break;
                    case 4:teste=false;break;
                    default:System.out.println("A opção deve ser um numero de 1 a 4!");break;
                }
            }catch(InputMismatchException e){
                System.out.println("A opção deve ser um numero!");
            }
        }
    }

    /** Menu_Login
     * Menu que aparecera após logar-se
     * @param conta conta logada
     */
    public static void Menu_Login(Conta conta){
        boolean teste = true;
        while(teste==true){
            System.out.println("-------------------------------\n"
                    + "1-Cadastrar Conta\n"
                    + "2-Monetização\n"                    
                    + "3-Relatorio\n"
                    + "4-Voltar\n"
                    + "5-Sair\n"
                    + "-------------------------------"
            );
            try{
                opcao = Console.scanInt("Digite a opção que deseja:");
                switch(opcao){
                    case 1:Conta_UI.Cadastrar_Conta(conta.getCliente());break;
                    case 2:Menu_Monetizacao(conta);break;                    
                    case 3:Menu_Relatorio(conta);break;
                    case 4:teste=false;break;
                    case 5:System.exit(0);
                    default:System.out.println("A opção deve ser um numero de 1 a 5!");break;
                }
            }catch(InputMismatchException e){
                System.out.println("A opção deve ser um numero!");
            }
        }
    }
    
    /** Menu_Monetizacao
     * Menu que aparecerá se a opção de monetizar for selecionada
     * @param conta conta logada
     */
    public static void Menu_Monetizacao(Conta conta){
        boolean teste = true;
        while(teste==true){
            System.out.println("-------------------------------\n"
                    + "1-Depositar dinheiro\n"
                    + "2-Retirar dinheiro\n"                    
                    + "3-Comprar produtos\n"
                    + "4-Transferir Dinheiro para outra conta\n"
                    + "5-Transferir Dinheiro de outra conta\n"
                    + "6-Visualizar saldo\n"
                    + "7-Voltar\n"
                    + "8-Sair\n"
                    + "-------------------------------"                    
            );
            try{
                opcao = Console.scanInt("Digite a opção que deseja:");
                switch(opcao){
                    case 1:Monetizacao_UI.Depositar(conta);break;
                    case 2:Monetizacao_UI.Retirar(conta);break;                    
                    case 3:Monetizacao_UI.Comprar_Produto(conta);break;
                    case 4:Monetizacao_UI.Transferir_Outro(conta);break;
                    case 5:Monetizacao_UI.Transferir_Mesmo(conta);break;
                    case 6:Creditacao.Visualizar_Saldo(conta);break;    
                    case 7:teste=false;break;
                    case 8:System.exit(0);
                    default:System.out.println("A opção deve ser um numero de 1 a 8!");break;
                }
            }catch(InputMismatchException e){
                System.out.println("A opção deve ser um numero!");
            }
        }
    }
    
    /** Menu_Relatorio
     * Menu que aparecerá se a opção de visualizar relatorios for selecionada
     * @param conta conta logada
     */
    public static void Menu_Relatorio(Conta conta){
        boolean teste = true;
        while(teste==true){
            System.out.println("-------------------------------\n"
                    + "1-Compras feitas\n"
                    + "2-Cliente que mais compra\n"
                    + "3-Cliente que mais faz processos de monetização\n"
                    + "4-Produto que mais vende\n"
                    + "5-Voltar\n"
                    + "6-Sair\n"
                    + "-------------------------------"
            );
            try{
                opcao = Console.scanInt("Digite a opção que deseja:");
                switch(opcao){
                    case 1:Mostrar_Relatorios.Mostrar_Produtos(Relatorio.compras_efetuadas(conta));break;
                    case 2:Mostrar_Relatorios.Mostrar_Clientes(Relatorio.cliente_mais_compra());break;
                    case 3:Mostrar_Relatorios.Mostrar_Clientes(Relatorio.cliente_mais_monetiza());break;
                    case 4:Mostrar_Relatorios.Mostrar_Produtos(Relatorio.Poduto_Mais_Vendido());break;
                    case 5:teste=false;break;
                    case 6:System.exit(0);
                    default:System.out.println("A opção deve ser um numero de 1 a 6!");break;
                }
            }catch(InputMismatchException e){
                System.out.println("A opção deve ser um numero!");
            }
        }
    }
    
}
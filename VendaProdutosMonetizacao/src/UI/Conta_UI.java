package UI;

import Classes.Cliente;
import Classes.Conta;
import Metodos.Login;
import Repositorios.Cliente_Repositorio;
import Repositorios.Conta_Repositorio;
import util.Console;

/** Conta_UI
 * Possui as interfaces relacionadas ao cliente e a conta
 * @author Guillermo1
 */
public class Conta_UI {
    /** Cadastrar_Cliente
     * Cadastra um cliente com uma conta inicial
     */
    public static void Cadastrar_Cliente(){
        try{
            String cpf = Console.scanString("Digite seu CPF:");
            if(cpf.length()!=11){
                System.out.println("O cpf deve conter 11 numeros");   
            }else{
                String nome = Console.scanString("Digite seu nome:");
                String email = Console.scanString("Digite seu e-mail:");
                if(email.contains("@")){
                    double saldo = Double.parseDouble(Console.scanString("Digite o seu saldo inicial:"));
                    String usuario = Console.scanString("Digite o nome da conta:");
                    Cliente cliente = new Cliente(cpf,nome,email);
                    if(Cliente_Repositorio.getCliente_repositorio().contains(cliente)){
                        System.out.println("Cliente já existe!");
                    }else if(Conta_Repositorio.getConta(nome)!=null){
                        System.out.println("Conta já existe!");
                    }else{    
                        Cliente_Repositorio.addCliente(cliente);
                        Conta_Repositorio.addConta(new Conta(saldo,cliente,usuario));
                    }
                }else{
                    System.out.println("Email invalido!");
                }
            }
        }catch(NumberFormatException e){
            System.out.println("o saldo deve ser um numero!");
        }
    }
    
    /** Cadastrar_Conta
     * cadastra outro cliente
     * @param cliente cliente que quer cadastrar outro cliente
     */
    public static void Cadastrar_Conta(Cliente cliente){
        try{
            double saldo = Double.parseDouble(Console.scanString("Digite o seu saldo inicial:"));
            String usuario = Console.scanString("Digite o nome da conta:");
            if(Conta_Repositorio.getConta(usuario) == null){
                Conta_Repositorio.addConta(new Conta(saldo,cliente,usuario));
            }else{
                System.out.println("Conta já existe!");
            }
        }catch(NumberFormatException e){
                System.out.println("o saldo deve ser um numero!");
        }
    }
    
    /** Logar_Conta
     * faz login em uma conta
     * @return conta do usuario
     */
    public static Conta Logar_Conta(){
        String usuario = Console.scanString("Digite o seu nome de usuario:");
        return Login.Logar_Conta(usuario);
    }
    
    
    
}
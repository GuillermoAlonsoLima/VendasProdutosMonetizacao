package Principal;

import Classes.Cliente;
import Classes.Conta;
import Classes.Produto;
import Menus.Menus;
import Repositorios.Conta_Repositorio;
import Repositorios.Cliente_Repositorio;
import Repositorios.Produto_Repositorio;
public class Main {
    public static void main(String[] args) {
        //teste v
        Cliente_Repositorio.addCliente(new Cliente("87576201053","Guillermo Alonso Lima","guillermoalonso.lima@gmail.com"));
        Cliente_Repositorio.addCliente(new Cliente("81394390025","Ana Maria Alonso Lima","anamaria.elpinar@gmail.com"));
        Cliente_Repositorio.addCliente(new Cliente("66766776677","Antonio","antonio@gmail.com"));
        Cliente_Repositorio.addCliente(new Cliente("90087878787","Diego","diego@gmail.com"));
        Cliente_Repositorio.addCliente(new Cliente("78787878787","Marcos","marcos.neto@gmail.com"));
        Conta_Repositorio.addConta(new Conta(900.00,Cliente_Repositorio.getCliente_repositorio().get(0),"guillermo"));
        Conta_Repositorio.addConta(new Conta(2400.50,Cliente_Repositorio.getCliente_repositorio().get(0),"guillermo666"));
        Conta_Repositorio.addConta(new Conta(2000.50,Cliente_Repositorio.getCliente_repositorio().get(1),"anamaria"));
        Conta_Repositorio.addConta(new Conta(500.55,Cliente_Repositorio.getCliente_repositorio().get(1),"elpinar"));
        Conta_Repositorio.addConta(new Conta(700.55,Cliente_Repositorio.getCliente_repositorio().get(2),"antonio"));
        Conta_Repositorio.addConta(new Conta(800.55,Cliente_Repositorio.getCliente_repositorio().get(3),"diego"));
        Conta_Repositorio.addConta(new Conta(900.55,Cliente_Repositorio.getCliente_repositorio().get(4),"marcos"));       
        Produto_Repositorio.addProduto(new Produto("leite",15.00));
        Produto_Repositorio.addProduto(new Produto("carne",20.00));
        Produto_Repositorio.addProduto(new Produto("vegetais",5.00));
        Produto_Repositorio.addProduto(new Produto("leite",15.00));
        Produto_Repositorio.addProduto(new Produto("leite",15.00));
        Produto_Repositorio.addProduto(new Produto("carne",20.00));
        Produto_Repositorio.addProduto(new Produto("frutas",30.00));
        Produto_Repositorio.addProduto(new Produto("calculadora",40.00));
        Produto_Repositorio.addProduto(new Produto("livro",50.00));
        //teste ^     
        Menus.Menu_Inicial();
    }
    
}

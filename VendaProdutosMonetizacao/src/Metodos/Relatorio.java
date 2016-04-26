package Metodos;

import Classes.Conta;
import Classes.Produto;
import Classes.Venda;
import Repositorios.Conta_Repositorio;
import Repositorios.Venda_Repositorio;
import java.util.ArrayList;

/** Relatorio
 * Possui os relatorios do sistema
 * @author Guillermo1
 */
public class Relatorio {
    
    /** produtos_Vendidos
     * O que faz:verifica todos os produtos vendidos pela conta no parâmetro; 
     * Como funciona:procura-se por vendas que contenham produtos com a conta correspondente 
     * ao vendedor,se encontrado, os produtos da venda serão adicionados ao ArrayList 
     * "produtos_vendidos" que corresponde aos produtos vendidos pela conta, após terminado, 
     * retorna-se os produtos que foram vendidos por esta conta;
     * @param conta conta que visualizara seus produtos vendidos
     * @return retorna os produtos vendidos por este usuario
     */
    public static ArrayList<Produto> produtos_Vendidos(Conta conta){
        ArrayList<Produto> produtos_vendidos = new ArrayList<>();
        for(Venda v : Venda_Repositorio.getVenda_repositorio()){
            if(v.getConta_vendedor() == conta){
                produtos_vendidos.add(v.getProdutos());
            }
        }
        return produtos_vendidos;
    }
    
    /** compras_efetuadas
     * O que faz:verifica todos os produtos comprados pela conta; 
     * Como funciona:procura-se por vendas que contenham a conta correspondente 
     * ao comprador,se encontrado, os produtos da venda serão adicionados ao ArrayList 
     * "produtos_comprados" que corresponde aos produtos comprados pela conta, após terminado, 
     * retorna-se os produtos que foram comprados por esta conta;
     * @param conta conta que visualizara os produtos que comprou
     * @return retorna os produtos comprados por este usuario
     */
    public static ArrayList<Produto> compras_efetuadas(Conta conta){
        ArrayList<Produto> produtos_comprados = new ArrayList<>();
        for(Venda v : Venda_Repositorio.getVenda_repositorio()){
            if(v.getConta_comprador() == conta){
                produtos_comprados.add(v.getProdutos());
            }
        }
        return produtos_comprados;
    }

    /** cliente_mais_compra
     * O que faz:verifica quais são os clientes que mais compram; 
     * Como funciona:o ArrayList "cliente_mais_compram" guarda todos os clientes que mais compram;se não há nenhum cliente 
     * cadastrado,retornará null;se há somente um cliente cadastrado,retornará este cliente;se não, se adicionará o primeiro 
     * cliente cadastrado como parâmetro inicial e se comparará como os proximos clientes consecutivamente; se o proximo cliente
     * possuir mais vendas que o mesmo, o "clientes_mais_vendem" se esvaziará e se adicionara o que possui mais vendas, se os dois 
     * forem iguais em vendas, se adicionara o novo além do mesmo.
     * @return retorna o arraylist com os clientes que mais compraram
     */
    public static ArrayList<Conta> cliente_mais_compra(){
        ArrayList<Conta> clientes_mais_compram = new ArrayList<>();
        if(Conta_Repositorio.getConta_repositorio().isEmpty()){
            return null;
        }else if(Conta_Repositorio.getConta_repositorio().size() == 1){
            clientes_mais_compram.add(Conta_Repositorio.getConta_repositorio().get(0));
            return clientes_mais_compram;
        }else{
            clientes_mais_compram.add(Conta_Repositorio.getConta_repositorio().get(0));
            for(int i = 1;i<Conta_Repositorio.getConta_repositorio().size();i++){
                if(Conta_Repositorio.getConta_repositorio().get(i).Compare_to_Compras(clientes_mais_compram.get(0)) == 1){
                    clientes_mais_compram.clear();
                    clientes_mais_compram.add(Conta_Repositorio.getConta_repositorio().get(i));
                }else if(Conta_Repositorio.getConta_repositorio().get(i).Compare_to_Compras(clientes_mais_compram.get(0)) == 0){
                    clientes_mais_compram.add(Conta_Repositorio.getConta_repositorio().get(i));
                }
            }
            return clientes_mais_compram;
        }
    }

    /** cliente_mais_vende
     * O que faz:verifica quais são os clientes que mais vendem; 
     * Como funciona:o ArrayList "cliente_mais_vendem" guarda todos os clientes que mais vendem;se não há nenhum cliente 
     * cadastrado,retornará null;se há somente um cliente cadastrado,retornará este cliente;se não, se adicionará o primeiro 
     * cliente cadastrado como parâmetro inicial e se comparará como os proximos clientes consecutivamente; se o proximo cliente
     * possuir mais vendas que o mesmo, o "clientes_mais_vendem" se esvaziará e se adicionara o que possui mais vendas, se os dois 
     * forem iguais em vendas, se adicionara o novo além do mesmo.
     * @return retorna o arraylist com os clientes que mais venderam
     */

    public static ArrayList<Conta> cliente_mais_vende(){
        ArrayList<Conta> clientes_mais_vendem = new ArrayList<>();
        if(Conta_Repositorio.getConta_repositorio().isEmpty()){
            return null;
        }else if(Conta_Repositorio.getConta_repositorio().size() == 1){
            clientes_mais_vendem.add(Conta_Repositorio.getConta_repositorio().get(0));
            return clientes_mais_vendem;
        }else{
            clientes_mais_vendem.add(Conta_Repositorio.getConta_repositorio().get(0));
            for(int i = 1;i<Conta_Repositorio.getConta_repositorio().size();i++){
                if(Conta_Repositorio.getConta_repositorio().get(i).Compare_to_Vendas(clientes_mais_vendem.get(0)) == 1){
                    clientes_mais_vendem.clear();
                    clientes_mais_vendem.add(Conta_Repositorio.getConta_repositorio().get(i));
                }else if(Conta_Repositorio.getConta_repositorio().get(i).Compare_to_Vendas(clientes_mais_vendem.get(0)) == 0){
                    clientes_mais_vendem.add(Conta_Repositorio.getConta_repositorio().get(i));
                }
            }
            return clientes_mais_vendem;
        }
    }

    /** cliente_mais_monetiza
     * O que faz:verifica quais são os clientes que mais monetizam; 
     * Como funciona:o ArrayList "cliente_mais_monetizam" guarda todos os clientes que mais monetizam;se não há nenhum cliente 
     * cadastrado,retornará null;se há somente um cliente cadastrado,retornará este cliente;se não, se adicionará o primeiro 
     * cliente cadastrado como parâmetro inicial e se comparará como os proximos clientes consecutivamente; se o proximo cliente
     * possuir mais vendas que o mesmo, o "clientes_mais_vendem" se esvaziará e se adicionara o que possui mais monetizações feitas,
     * se os dois forem iguais em monetizações feitas, se adicionara o novo além do mesmo.
     * @return retorna os clientes que mais fizeram processos de monetização
     */
    public static ArrayList<Conta> cliente_mais_monetiza(){
        ArrayList<Conta> clientes_mais_monetizam = new ArrayList<>();
        if(Conta_Repositorio.getConta_repositorio().isEmpty()){
            return null;
        }else if(Conta_Repositorio.getConta_repositorio().size() == 1){
            clientes_mais_monetizam.add(Conta_Repositorio.getConta_repositorio().get(0));
            return clientes_mais_monetizam;
        }else{
            clientes_mais_monetizam.add(Conta_Repositorio.getConta_repositorio().get(0));
            for(int i = 1;i<Conta_Repositorio.getConta_repositorio().size();i++){
                if(Conta_Repositorio.getConta_repositorio().get(i).Compare_to_Monetizacao(clientes_mais_monetizam.get(0)) == 1){
                    clientes_mais_monetizam.clear();
                    clientes_mais_monetizam.add(Conta_Repositorio.getConta_repositorio().get(i));
                }else if(Conta_Repositorio.getConta_repositorio().get(i).Compare_to_Monetizacao(clientes_mais_monetizam.get(0)) == 0){
                    clientes_mais_monetizam.add(Conta_Repositorio.getConta_repositorio().get(i));
                }
            }
            return clientes_mais_monetizam;
        }
    }
 
}
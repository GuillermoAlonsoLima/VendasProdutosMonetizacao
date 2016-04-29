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
    private static int quantidade;
        
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
            quantidade = 1;
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
            quantidade = clientes_mais_compram.get(0).getQtd_compras();
            return clientes_mais_compram;
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
            quantidade = 1;
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
            quantidade = clientes_mais_monetizam.get(0).getQtd_monetizacao();
            return clientes_mais_monetizam;
        }
    }
    
    /** Produto_Mais_Vendido
     * Se houver somente uma venda cadastrada, retornará o produto da mesma;
     * Se houver mais de uma, verifica-se a quantidade de vezes que cada produto foi vendido, se um produto vendeu mais que 
     * os anteriores se esvasiará o ArrayList e se adicionara o novo, se forem iguais adicionara o novo sem resetar o ArrayList;
     * Na verificação se verifica quais são os produtos nas vendas com o mesmo nome que o apontado atualmente, se houver aumenta 
     * o contador de quantidade de produtos vendidos;
     * @return retorna os produtos mais vendidos
     */
    public static ArrayList<Produto> Poduto_Mais_Vendido(){
        ArrayList<Produto> produtos_mais_vendidos = new ArrayList<>();
        if(Venda_Repositorio.getVenda_repositorio().size() == 1){
            produtos_mais_vendidos.add(Venda_Repositorio.getVenda_repositorio().get(0).getProdutos());
            quantidade = 1;
            return produtos_mais_vendidos;
        }else if(Venda_Repositorio.getVenda_repositorio() != null){
            String produto_atual_nome,produto_antigo;
            int produto_atual = 0,outro_produto;
            Produto produto_atual_objeto;
            for(int nome = 0;nome<Venda_Repositorio.getVenda_repositorio().size();nome++){
                outro_produto = 0;
                if(nome>0){
                    produto_antigo = Venda_Repositorio.getVenda_repositorio().get(nome-1).getProdutos().getNome();
                }else{
                    produto_antigo = null;
                }
                produto_atual_objeto = Venda_Repositorio.getVenda_repositorio().get(nome).getProdutos();
                produto_atual_nome = Venda_Repositorio.getVenda_repositorio().get(nome).getProdutos().getNome();
                if(!produto_atual_nome.equals(produto_antigo)){
                    for(int produto = 0;produto<Venda_Repositorio.getVenda_repositorio().size();produto++){
                        if(Venda_Repositorio.getVenda_repositorio().get(produto).getProdutos().getNome().equals(produto_atual_nome)){
                            outro_produto++;
                        }
                    }
                    if(outro_produto > produto_atual){
                        produto_atual = outro_produto; 
                        produtos_mais_vendidos.clear();
                        produtos_mais_vendidos.add(produto_atual_objeto);
                    }else if(outro_produto == produto_atual){
                        produtos_mais_vendidos.add(produto_atual_objeto);
                    }
                }
            }
            quantidade = produto_atual;
            return produtos_mais_vendidos;
        }else{
            return null;
        }
    }

    public static int getQuantidade() {
        return quantidade;
    }

}
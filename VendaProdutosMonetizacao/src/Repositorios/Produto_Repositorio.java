package Repositorios;

import Classes.Conta;
import Classes.Produto;
import java.util.ArrayList;
/** Produto_Repositorio
 * Onde os produtos são registrados
 * @author Guillermo1
 */
public class Produto_Repositorio {
    private static final ArrayList<Produto> produto_repositorio = new ArrayList<>();
    
    /** addProduto
     * adiciona produto
     * @param produto adiciona produto ao "produto_repositorio"
     */
    public static void addProduto(Produto produto){
        produto_repositorio.add(produto);
    }
    
    /** delProduto
     * deleta produto
     * @param produto deleta produto do "produto_repositorio"
     */
    public static void delProduto(Produto produto){
        produto_repositorio.remove(produto);
    }

    /** getProduto_repositorio
     * Retorna os produtos cadastrados
     * @return Retorna os produtos cadastrados
     */
    public static ArrayList<Produto> getProduto_repositorio() {
        return produto_repositorio;
    }
    
    /** getProduto
     * Retorna o produto que possuir o nome colocado ignorando o que for do mesmo comprador
     * @param nome nome do produto a procurar
     * @param comprador pessoa que esta comprando o produto 
     * @return retorna o produto encontrado
     */
    public static Produto getProduto(String nome){
        for(Produto p : produto_repositorio){
            if(p.getNome().equals(nome)){
                return p;
            }
        }
        return null;
    }
    
}
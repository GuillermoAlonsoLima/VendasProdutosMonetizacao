package Repositorios;

import Classes.Venda;
import java.util.ArrayList;
/** Venda_Repositorio
 * Onde as vendas são registradas
 * @author Guillermo1
 */
public class Venda_Repositorio {
    private static final ArrayList<Venda> venda_repositorio = new ArrayList<>();

    /** getVenda_repositorio
     * Retorna as vendas cadastradas
     * @return Retorna as vendas cadastradas
     */
    public static ArrayList<Venda> getVenda_repositorio() {
        return venda_repositorio;
    }
    
    /** addVenda
     * adiciona venda
     * @param venda adiciona venda ao "venda_repositorio"
     */
    public static void addVenda(Venda venda) {
        venda_repositorio.add(venda);
    }
    
    /** delVenda
     * deleta venda
     * @param venda deleta venda do "venda_repositorio"
     */
    public static void delVenda(Venda venda){
        venda_repositorio.remove(venda);
    }
}
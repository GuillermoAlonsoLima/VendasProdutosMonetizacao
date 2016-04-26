package Repositorios;

import Classes.Cliente;
import java.util.ArrayList;

/** Cliente_Repositorio
 * Onde os clientes são registrados
 * @author Guillermo1
 */
public class Cliente_Repositorio {
    private static final ArrayList<Cliente> cliente_repositorio = new ArrayList<>();
    
    /** getCliente_repositorio
     * Retorna os clientes cadastrados
     * @return Retorna os clientes cadastrados
     */
    public static ArrayList<Cliente> getCliente_repositorio() {
        return cliente_repositorio;
    }
    
    /** addCliente
     * adiciona cliente
     * @param cliente adiciona cliente ao "cliente_repositorio"
     */
    public static void addCliente(Cliente cliente){
        cliente_repositorio.add(cliente);
    }
     
    /** delCliente
     * deleta cliente 
     * @param cliente deleta cliente do "cliente_repositorio"
     */
    public static void delCliente(Cliente cliente){
        cliente_repositorio.remove(cliente);
    }
    
}
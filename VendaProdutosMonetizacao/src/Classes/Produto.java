package Classes;

/** Produto
 * Produto é o objeto ue pode ser comprado e vendido
 * @author Guillermo1
 */
public class Produto {
    private static int codigo_principal;
    private int codigo;
    private String nome;
    private double preco;
    private Conta conta;

    /** Produto
     * Construtor do produto
     * o codigo principal é incrementado e "static" por representar o incremento do "id";
     * o outro codigo é o id da venda em si;
     * @param nome nome do produto
     * @param preco preço do produto
     * @param conta conta do produto
     */
    public Produto(String nome, double preco, Conta conta) {
        codigo=codigo_principal;
        codigo_principal++;
        this.nome = nome;
        this.preco = preco;
        this.conta = conta;
    }
    /** getConta
     * retorna conta
     * @return retorna conta
     */
    public Conta getConta() {
        return conta;
    }
    /** setConta
     * configura conta
     * @param conta conta a mudar
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }
    /** getCodigo
     * retorna codigo
     * @return retorna codigo
     */
    public int getCodigo() {
        return codigo;
    } 
    /** setCodigo
     * configura codigo
     * @param codigo codigo a mudar
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    /** getNome
     * retorna nome
     * @return retorna nome
     */
    public String getNome() {
        return nome;
    }
    /** setNome
     * configura nome
     * @param nome nome a mudar
     */
    public void setNome(String nome) {
        this.nome = nome;
    } 
    /** getPreco
     * retorna preço
     * @return retorna preço
     */
    public double getPreco() {
        return preco;
    }
    /** setPreco
     * configura preço
     * @param preco preço a mudar
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
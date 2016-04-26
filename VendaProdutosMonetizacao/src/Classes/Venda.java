package Classes;

import java.util.Date;

/** Venda
 * Venda possui informações de um processo de compra/venda de produtos
 * @author Guillermo1
 */
public final class Venda {
    private static int codigo_principal = 1;
    private int codigo;
    private Conta conta_comprador;
    private Conta conta_vendedor;
    private final Date data_venda;
    private final double valor;
    private Produto produto;
    Date data = new Date();

    /** Venda
     * o codigo principal é incrementado e "static" por representar o incremento do "id";
     * o outro codigo é o id da venda em si;
     * a "data_venda" recebe a data atual;
     * o ArrayList "produtos" possui todos os produtos comprados nesta venda;
     * a conta cadastrada é a do comprador, a do vendedor pode ser verificada nos produtos;
     * @param conta conta da pessoa que compra
     * @param produto produto da venda
     */
    public Venda(Conta conta,Produto produto) {
        codigo=codigo_principal;
        codigo_principal++;
        data_venda = data;
        conta_comprador = conta;
        conta_vendedor = produto.getConta();
        this.produto = produto;
        valor = produto.getPreco();
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
    /** getData
     * retorna data
     * @return retorna data
     */
    public Date getData() {
        return data;
    }
    /** setData
     * configura data
     * @param data data a mudar
     */
    public void setData(Date data) {
        this.data = data;
    }
    /** getConta_comprador
     * retorna conta comprador
     * @return retorna conta comprador
     */
    public Conta getConta_comprador() {
        return conta_comprador;
    }
    /** setConta_Comprador
     * configura conta
     * @param conta_comprador conta a mudar
     */
    public void setConta_Comprador(Conta conta_comprador) {
        this.conta_comprador = conta_comprador;
    }
    /** getProdutos
     * retorna produtos
     * @return retorna produtos
     */
    public Produto getProdutos() {
        return produto;
    }
    /** setProdutos
     * configura produtos
     * @param produto produto a mudar
     */
    public void setProdutos(Produto produto) {
        this.produto = produto;
    }
    /** getValor
     * retorna valor
     * @return retorna valor
     */
    public double getValor(){
        return valor;
    }

    /** getConta_vendedor
     * Retorna conta vendedor
     * @return Retorna conta vendedor
     */
    public Conta getConta_vendedor() {
        return conta_vendedor;
    }

    /** setConta_vendedor
     * configura conta do vendedor
     * @param conta_vendedor conta do vendedor a mudar
     */
    public void setConta_vendedor(Conta conta_vendedor) {
        this.conta_vendedor = conta_vendedor;
    }
    
    

}
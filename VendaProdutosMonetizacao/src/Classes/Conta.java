package Classes;

/** Conta
 * Conta que o cliente pode usar para entrar e utilizar o sistema
 * @author Guillermo1
 */
public class Conta {
    private static int numero_principal;
    private int numero;
    private double saldo;
    private String usuario;
    private Cliente cliente;
    private int qtd_compras,qtd_vendas,qtd_monetizacao;

    /** Conta
     * Construtor da Conta 
     * o codigo principal é incrementado e "static" por representar o incremento do "id";
     * o outro codigo é o id da venda em si;
     * @param saldo saldo da Conta 
     * @param cliente cliente da Conta 
     * @param usuario usuario da Conta 
     */
    public Conta(double saldo, Cliente cliente,String usuario) {
        numero=numero_principal;
        numero_principal++;
        this.saldo = saldo;
        this.cliente = cliente;
        this.usuario = usuario;
        qtd_compras = 0;
        qtd_vendas = 0;
        qtd_monetizacao = 0;
    }
    /** getUsuario
     * retorna usuario
     * @return retorna usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /** setUsuario
     * configura usuario
     * @param usuario usuario a mudar
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /** getNumero
     * retorna numero identificador
     * @return retorna numero identificador
     */
    public int getNumero() {
        return numero;
    }
    /** setNumero
     * configura numero identificador
     * @param numero numero identificador a mudar
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    /** getSaldo
     * retorna saldo
     * @return retorna saldo
     */
    public double getSaldo() {
        return saldo;
    }
    /** setSaldo
     * configura saldo
     * @param saldo saldo a mudar
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /** getCliente
     * retorna o dono da conta
     * @return retorna o dono da conta
     */
    public Cliente getCliente() {
        return cliente;
    }
    /** setCliente
     * configura dono da conta
     * @param cliente dono da conta a mudar
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /** getQtd_compras
     * retorna quantidade de compras
     * @return retorna quantidade de compras
     */
    public int getQtd_compras() {
        return qtd_compras;
    }

    /** setQtd_compras
     * aumenta a quantidade de compras
     */
    public void setQtd_compras() {
        qtd_compras++;
    }

    /** getQtd_vendas
     * retorna quantidade de vendas
     * @return retorna quantidade de vendas
     */
    public int getQtd_vendas() {
        return qtd_vendas;
    }

    /** setQtd_vendas
     * aumenta a quantidade de vendas
     */
    public void setQtd_vendas() {
        qtd_vendas++;
    }

    /** getQtd_monetizacao
     * retorna quantidade de operações de monetização
     * @return retorna quantidade de operações de monetização
     */
    public int getQtd_monetizacao() {
        return qtd_monetizacao;
    }

    /** setQtd_monetizacao
     * aumenta a quantidade de operações de monetização
     */
    public void setQtd_monetizacao() {
        qtd_monetizacao++;
    }
    
    
    
    /** Compare_to_Compras
     * O que faz:Compara a quantidade de compras de dois usuarios; 
     * Como funciona:se a qtd de compras do usuario comparado for menor que o usuario que compara,retornara "1",
     * se a qtd de compras do usuario comparado for maior que o usuario que compara,retornara "false", se for igual 
     * não retornará nada;
     * @param conta
     * @return retorna "1" se a qtd deste usuario for maior que o outro, "false" se for o contrario
     *                 e null se os dois forem iguais;
     */
    public int Compare_to_Compras(Conta conta){
        if(this.getQtd_compras()<conta.getQtd_compras()){
            return -1;
        }else if(this.getQtd_compras()==conta.getQtd_compras()){
            return 0;
        }else{
            return 1;
        }
    }

    /** Compare_to_Vendas
     * O que faz:Compara a quantidade de vendas de dois usuarios; 
     * Como funciona:se a qtd de vendas do usuario comparado for menor que o usuario que compara,retornara "1",
     * se a qtd de vendas do usuario comparado for maior que o usuario que compara,retornara "false", se for igual 
     * não retornará nada;
     * @param conta conta a comparar
     * @return retorna "1" se a qtd de vendas deste usuario for maior que o outro, "false" se for o contrario
     *                 e null se os dois forem iguais;
     */
    public int Compare_to_Vendas(Conta conta){
       if(this.getQtd_vendas()>conta.getQtd_vendas()){
            return 1;
        }else if(this.getQtd_vendas()<conta.getQtd_vendas()){
            return -1;
        }else{
            return 0;
        }
    }

    /** Compare_to_Monetizacao
     * O que faz:Compara a quantidade de operações de monetização de dois usuarios; 
     * Como funciona:se a qtd de operações de monetização do usuario comparado for menor que o usuario que compara,retornara "1",
     * se a qtd de operações de monetização do usuario comparado for maior que o usuario que compara,retornara "false", se for igual 
     * não retornará nada;
     * @param conta conta a comparar
     * @return retorna "1" se a qtd de creditações deste usuario for maior que o outro, "false" se for o contrario
     *                 e null se os dois forem iguais;
     */
    public int Compare_to_Monetizacao(Conta conta){
       if(this.getQtd_monetizacao()>conta.getQtd_monetizacao()){
            return 1;
        }else if(this.getQtd_monetizacao()<conta.getQtd_monetizacao()){
            return -1;
        }else{
            return 0;
        }
    }
    
}
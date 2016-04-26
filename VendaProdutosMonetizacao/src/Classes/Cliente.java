package Classes;

/** Cliente
 * O cliente é a pessoa física que está acessando o sistema, ele pode ter varias contas;
 * @author Guillermo1
 */
public class Cliente {
    private String cpf,nome,email;

    /** Cliente
     * Construtor do cliente
     * @param cpf cpf do cliente
     * @param nome nome do cliente
     * @param email email do cliente
     */
    public Cliente(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email; 
    }

    /** getCpf
     * retorna cpf
     * @return retorna cpf
     */
    public String getCpf() {
        return cpf;
    }

    /** setCpf
     * configura cpf
     * @param cpf cpf a mudar
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /** getNome
     * retorna o nome
     * @return retorna o nome
     */
    public String getNome() {
        return nome;
    }

    /** setNome
     * configura o nome
     * @param nome nome a mudar
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** getEmail
     * retorna email
     * @return retorna email
     */
    public String getEmail() {
        return email;
    }

    /** setEmail
     * configura email
     * @param email email a mudar
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
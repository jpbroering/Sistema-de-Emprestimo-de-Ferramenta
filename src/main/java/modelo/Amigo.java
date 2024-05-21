package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

/**
 * Classe que representa um amigo, herdando de EstruturaBase. Possui um telefone
 * e métodos para manipular e persistir os dados no banco de dados.
 */
public class Amigo extends EstruturaBase {

    private String telefone;
    AmigoDAO dao;

    /**
     * Construtor padrão que inicializa um objeto Amigo com valores padrão.
     */
    public Amigo() {
        this(0, "", "");
    }

    /**
     * Construtor que inicializa um objeto Amigo com os valores fornecidos.
     *
     * @param id o ID do amigo
     * @param nome o nome do amigo
     * @param telefone o telefone do amigo
     */
    public Amigo(int id, String nome, String telefone) {
        super(id, nome);
        this.telefone = telefone;
        dao = new AmigoDAO();
    }

    /**
     * Retorna o telefone do amigo.
     *
     * @return o telefone do amigo
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do amigo.
     *
     * @param telefone o novo telefone do amigo
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna uma representação em String do objeto Amigo.
     *
     * @return uma String contendo as informações do amigo
     */
    @Override
    public String toString() {
        return super.toString() + ", Telefone: " + telefone;
    }

    /**
     * Retorna uma lista de todos os amigos cadastrados.
     *
     * @return uma lista de objetos Amigo
     */
    public ArrayList<Amigo> getMinhaLista() {
        return dao.getMinhalista();
    }

    /**
     * Insere um novo amigo no banco de dados.
     *
     * @param nome o nome do amigo
     * @param telefone o telefone do amigo
     * @return true se a inserção for bem-sucedida
     */
    public boolean InsertAmigoBD(String nome, String telefone) {
        int id = dao.maiorID() + 1;

        Amigo objeto = new Amigo(id, nome, telefone);
        dao.insertAmigoBD(objeto);
        return true;

    }

    public boolean deleteAmigoBD(int id) {
        dao.deleteAmigoBD(id);
        return true;
    }

    public boolean updateAmigoBD(int id, String nome, String telefone) {
        Amigo objeto = new Amigo(id, nome, telefone);
        dao.updateAmigoBD(objeto);
        return true;
    }

    public Amigo carregaAmigoBD(int id) {
        return dao.carregaAmigoBD(id);
    }
}

package db.pojos;

/**
 *
 * @author David Vazquez
 */
public class ItemPOJO {

    private int id;
    private String reactivo;
    private String r1;
    private String r2;
    private String r3;
    private int idDocumento;
    private int idCategoria;

    public ItemPOJO() {
    }

    public ItemPOJO(String reactivo, String r1, String r2, String r3, int idDocumento, int idCategoria) {
        this.reactivo = reactivo;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.idDocumento = idDocumento;
        this.idCategoria = idCategoria;
    }

    public ItemPOJO(int id, String reactivo, String r1, String r2, String r3, int idDocumento, int idCategoria) {
        this.id = id;
        this.reactivo = reactivo;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.idDocumento = idDocumento;
        this.idCategoria = idCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReactivo() {
        return reactivo;
    }

    public void setReactivo(String reactivo) {
        this.reactivo = reactivo;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}

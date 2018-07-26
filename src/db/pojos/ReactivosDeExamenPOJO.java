package db.pojos;

/**
 *
 * @author David Vazquez
 */
public class ReactivosDeExamenPOJO {

    private int id;
    private boolean correcto;
    private int idReactivo;
    private int idExamen;

    public ReactivosDeExamenPOJO() {
    }

    public ReactivosDeExamenPOJO(boolean correcto, int idReactivo, int idExamen) {
        this.correcto = correcto;
        this.idReactivo = idReactivo;
        this.idExamen = idExamen;
    }

    public ReactivosDeExamenPOJO(int id, boolean correcto, int idReactivo, int idExamen) {
        this.id = id;
        this.correcto = correcto;
        this.idReactivo = idReactivo;
        this.idExamen = idExamen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCorrecto() {
        return correcto;
    }

    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }

    public int getIdReactivo() {
        return idReactivo;
    }

    public void setIdReactivo(int idReactivo) {
        this.idReactivo = idReactivo;
    }

    public int getIdExamen() {
        return idExamen;
    }

    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

}

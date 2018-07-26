package db.pojos;

import java.sql.Timestamp;

/**
 *
 * @author David Vazquez
 */
public class TestPOJO {

    private int id;
    private int correctas;
    private int incorrectas;
    private int puntuacion;
    private Timestamp fechaHora;

    public TestPOJO() {
    }

    public TestPOJO(int correctas, int incorrectas, int puntuacion, Timestamp fechaHora) {
        this.correctas = correctas;
        this.incorrectas = incorrectas;
        this.puntuacion = puntuacion;
        this.fechaHora = fechaHora;
    }

    public TestPOJO(int id, int correctas, int incorrectas, int puntuacion, Timestamp fechaHora) {
        this.id = id;
        this.correctas = correctas;
        this.incorrectas = incorrectas;
        this.puntuacion = puntuacion;
        this.fechaHora = fechaHora;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorrectas() {
        return correctas;
    }

    public void setCorrectas(int correctas) {
        this.correctas = correctas;
    }

    public int getIncorrectas() {
        return incorrectas;
    }

    public void setIncorrectas(int incorrectas) {
        this.incorrectas = incorrectas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}

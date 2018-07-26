package db.pojos;

import java.sql.Timestamp;

/**
 *
 * @author David Vazquez
 */
public class TestPOJO {

    private int id;
    private int corrects;
    private int incorrects;
    private int score;
    private Timestamp timestamp;

    public TestPOJO() {
    }

    public TestPOJO(int id, int corrects, int incorrects, int score, Timestamp timestamp) {
        this.id = id;
        this.corrects = corrects;
        this.incorrects = incorrects;
        this.score = score;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorrects() {
        return corrects;
    }

    public void setCorrects(int corrects) {
        this.corrects = corrects;
    }

    public int getIncorrects() {
        return incorrects;
    }

    public void setIncorrects(int incorrects) {
        this.incorrects = incorrects;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}

package db.pojos;

/**
 *
 * @author David Vazquez
 */
public class TestItemsPOJO {

    private int id;
    private boolean correct;
    private int idItem;
    private int idTest;

    public TestItemsPOJO() {
    }

    public TestItemsPOJO(int id, boolean correct, int idItem, int idTest) {
        this.id = id;
        this.correct = correct;
        this.idItem = idItem;
        this.idTest = idTest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

}

package db.pojos;

/**
 *
 * @author David Vazquez
 */
public class ItemPOJO {

    private int id;
    private String name;
    private String a1;
    private String a2;
    private String a3;
    private int idDocument;
    private int idCategory;

    public ItemPOJO() {
    }

    public ItemPOJO(int id, String name, String a1, String a2, String a3, int idDocument, int idCategory) {
        this.id = id;
        this.name = name;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.idDocument = idDocument;
        this.idCategory = idCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public int getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(int idDocument) {
        this.idDocument = idDocument;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

}

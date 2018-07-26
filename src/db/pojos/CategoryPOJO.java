package db.pojos;

/**
 *
 * @author David Vazquez
 */
public class CategoryPOJO {

    private int id;
    private String name;

    public CategoryPOJO() {
    }

    public CategoryPOJO(int id, String name) {
        this.id = id;
        this.name = name;
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

}

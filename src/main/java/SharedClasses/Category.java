package SharedClasses;

/**
 * Created by Shahar on 29/03/17.
 */
public class Category
{
    private int id;
    private String name;
    private int idFather;

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

    public int getIdFather() {
        return idFather;
    }

    public void setIdFather(int idFather) {
        this.idFather = idFather;
    }
}

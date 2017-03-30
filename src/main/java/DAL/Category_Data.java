package DAL;

import SharedClasses.Category;

import java.sql.Connection;

/**
 * Created by Shahar on 29/03/17.
 */
public class  Category_Data
{
    Connection connection;
    Category_Data(Connection c)
    {
        connection = c;
    }

    public boolean addCategory(Category c)
    {
        return false;
    }
    /*
        If category not found returns NULL
     */
    public Category getCategory(int id)
    {
        return null;
    }
    public boolean updateCategoryId(int id)
    {
        return false;
    }
    public boolean updateCategoryName(String name)
    {
        return false;
    }
    public boolean updateCategoryIdFather(int id)
    {
        return false;
    }
}
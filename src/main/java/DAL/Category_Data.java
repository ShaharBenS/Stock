package DAL;

import SharedClasses.Category;

/**
 * Created by Shahar on 29/03/17.
 */
public class  Category_Data
{
    /*
        The constructor gets the SQL connection here
     */
    Category_Data()
    {

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
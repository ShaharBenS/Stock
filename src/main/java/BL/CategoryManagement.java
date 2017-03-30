package BL;

import DAL.Category_Data;
import SharedClasses.Category;

/**
 * Created by Shahar on 29/03/17.
 */

public class CategoryManagement
{
    private Category_Data _CD;
    public CategoryManagement(Category_Data cd)
    {
        _CD = cd;
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
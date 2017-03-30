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

    public boolean addCategory(String line)
    {
        String[] cParts = line.split(" ");
        if(cParts.length != 2 && cParts.length != 3) return false;
        Category c;
        try
        {
            /*0*/ int id = Integer.parseInt(cParts[0]);
            if(cParts[0].length() != 3) return false;
            /*1*/ /* << NOTHING TO CHECK << */
            int idF = 0;
            if(cParts.length == 3) {
                if (cParts[0].length() != 3) return false;
                else idF = Integer.parseInt(cParts[2]);
            }

            c = new Category(id, cParts[1], idF);

        } catch (Exception e) { return false; }
        return _CD.addCategory(c);
    }
    /*
        If category not found returns NULL
     */
    public Category getCategory(int id)
    {
        return _CD.getCategory(id);
    }

    public boolean updateCategoryId(String line)
    {
        String[] prop = line.split(" ");
        if(prop.length != 2) return false;
        try{
            if(prop[0].length() != 3 || prop[1].length() != 3) return false;
            int id = Integer.parseInt(prop[0]);
            int nid = Integer.parseInt(prop[1]);
            return _CD.updateCategoryId(id, nid);
        } catch(Exception e){ return  false; }
    }
    public boolean updateCategoryName(String line)
    {
        String[] prop = line.split(" ");
        if(prop.length != 2) return false;
        try{
            if(prop[0].length() != 3) return false;
            int id = Integer.parseInt(prop[0]);
            return _CD.updateCategoryName(id, prop[1]);
        } catch(Exception e){ return  false; }
    }
    public boolean updateCategoryIdFather(String line)
    {
        String[] prop = line.split(" ");
        if(prop.length != 2) return false;
        try{
            if(prop[0].length() != 3 || prop[1].length() != 3) return false;
            int id = Integer.parseInt(prop[0]);
            int nid = Integer.parseInt(prop[1]);
            return _CD.updateCategoryId(id, nid);
        } catch(Exception e){ return  false; }
    }

}
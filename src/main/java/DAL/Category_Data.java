package DAL;

import SharedClasses.Category;

import java.sql.*;

/**
 * Created by Shahar on 29/03/17.
 */
public class  Category_Data
{
    Connection connection;
    public Category_Data(Connection c)
    {
        connection = c;
    }

    public boolean addCategory(Category c)
    {
        String query = "INSERT INTO CATEGORY(ID,NAME,ID_FATHER) VALUES(?,?,?)";
        try {
            PreparedStatement _ps = connection.prepareStatement(query);
            _ps.setInt(1, c.getId());
            _ps.setString(2, c.getName());
            _ps.setString(3, c.getIdFather() == -1 ? "NULL" : ""+c.getIdFather());
            _ps.executeUpdate();
            return true;

        } catch (SQLException e)
        {
            return false;
        }

    }
    /*
        If category not found returns NULL
     */
    public Category getCategory(int id)
    {
        String query = "SELECT * FROM CATEGORY WHERE ID = "+id+";";
        Category category = null;
        try
        {
            Statement state = connection.createStatement();
            ResultSet result = state.executeQuery(query);
            category = new Category();

            category.setId(result.getInt("ID"));
            category.setName(result.getString("NAME"));
            category.setIdFather(result.getString("ID_FATHER").equals("NULL")
            ? -1 : result.getInt("ID_FATHER"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }
    public boolean updateCategoryId(int id,int newID)
    {
        String query = "UPDATE CATEGORY SET ID = ? WHERE ID = ?";
        try {
            PreparedStatement _ps = connection.prepareStatement(query);
            _ps.setInt(1, newID);
            _ps.setInt(2, id);
            _ps.executeUpdate();

            return true;

        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateCategoryName(int id,String name)
    {
        String query = "UPDATE CATEGORY SET NAME = ? WHERE ID = ?";
        try {
            PreparedStatement _ps = connection.prepareStatement(query);
            _ps.setString(1, name);
            _ps.setInt(2, id);
            _ps.executeUpdate();

            return true;

        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateCategoryIdFather(int id,int newFatherId)
    {
        String query = "UPDATE CATEGORY SET ID_FATHER = ? WHERE ID = ?";
        try {
             PreparedStatement _ps = connection.prepareStatement(query);
            _ps.setInt(1, newFatherId);
            _ps.setInt(2, id);
            _ps.executeUpdate();

            return true;

        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }
}
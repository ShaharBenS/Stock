package DAL;

import SharedClasses.Products;

import java.sql.*;
import java.util.Date;

/**
 * Created by Shahar on 29/03/17.
 */
public class Product_Data
{

    Connection connection;
    public Product_Data(Connection c)
    {
        connection = c;
    }

    /* DATE FOR REGULAR PROPERTIES */

    // ADD NEW PRODUCT TO DATABASE
    public boolean addProduct(Products p)
    {
        String query = "INSERT INTO PRODUCTS(ID, LOCATION, MANUFACTURE, AMOUNT_STORE, AMOUNT_STORAGE, AMOUNT_DEFECT, MINIMAL_AMOUNT, CATEGORY_CODE) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement _ps = connection.prepareStatement(query);

            _ps.setInt(1,p.getId());
            _ps.setString(2,p.getLocation());
            _ps.setString(3,p.getManufacture());
            _ps.setInt(4, p.getAmountInStore());
            _ps.setInt(5, p.getAmountInWarehouse());
            _ps.setInt(6, p.getDefectAmount());
            _ps.setInt(7, p.getMinimalAmount());
            _ps.setInt(8, p.getCatergoryCode());

            _ps.executeUpdate();
            return true;

        } catch (SQLException e)
        {
            return false;
        }
    }

    //RETURN PRODUCT FROM DATABASE IF EXISTS, ELSE RETURN NULL
    public Products getProduct(int id)
    {
        String query1 = "SELECT * FROM PRODUCTS WHERE ID = "+id+";";
        String query2 = "SELECT ID,PRICE_COST,PRICE_SELL,DISCOUNT,DATE_START,DATE_END FROM PRODUCTS_PRICE" +
                "JOIN PRODUCTS WHERE PRODUCTS.ID = PRODUCTS_PRICE.ID;";
        Products products = null;
        try
        {
            Statement state = connection.createStatement();
            ResultSet result = state.executeQuery(query1);

            //TODO:: just initialize the variables in the constractor here ↓↓↓↓ instead of setters!
            ///*TODO:: look up ! ^^^ this is the line : */products = new Products();

            products.setId(result.getInt("ID"));
            products.setLocation(result.getString("LOCATION"));
            products.setManufacture(result.getString("MANUFACTURE"));
            products.setAmountInStore(result.getInt("AMOUNT_STORE"));
            products.setAmountInWarehouse(result.getInt("AMOUNT_STORAGE"));
            products.setDefectAmount(result.getInt("DEFECT_AMOUNT"));
            products.setMinimalAmount(result.getInt("MINIMAL_AMOUNT"));
            products.setCatergoryCode(result.getInt("CATEGORY_CODE"));
            products.setCurrentAmount(products.getDefectAmount()+products.getAmountInStore()+products.getAmountInWarehouse());

            state = connection.createStatement();
            result = state.executeQuery(query2);

            products.setBuyPrice(result.getInt("PRICE_COST"));
            products.setSellPrice(result.getInt("PRICE_SELL"));
            products.setDiscount(result.getInt("DISCOUNT"));
            products.setDateStartDiscount(result.getDate("DATE_START"));
            products.setDateEndDiscount(result.getDate("DATE_END"));



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    /*
     * This method gets the name of the column the id of the products and the new value.
     */
    private boolean updateColumnInProduct(String columnName, int id, Object newValue)
    {
        String query = "UPDATE PRODUCT SET ? = ? WHERE ID = ?";
        try {
            PreparedStatement _ps = connection.prepareStatement(query);
            _ps.setString(1, columnName);
            _ps.setObject(2, newValue);
            _ps.setInt(3, id);
            _ps.executeUpdate();

            return true;

        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }


    public boolean updateProductId(int id, int newId)
    {
        return updateColumnInProduct("ID",id,newId);
    }

    public boolean updateProductLocation(int id, String location)
    {
        return updateColumnInProduct("LOCATION",id,location);
    }

    public boolean updateProductManufacture(int id, String manufacture)
    {
        return updateColumnInProduct("MANUFACTURE",id,manufacture);
    }

    public boolean updateProductAmountInWarehouse(int id, int amount)
    {
        return updateColumnInProduct("AMOUNT_STORAGE",id,amount);
    }

    public boolean updateProductAmountInStore(int id, int amount)
    {
        return updateColumnInProduct("AMOUNT_STORE",id,amount);
    }

    public boolean updateProductDefectAmount(int id, int amount)
    {
        return updateColumnInProduct("AMOUNT_DEFECT",id,amount);
    }

    public boolean updateProductCategoryCode(int id, int categoryCode)
    {
        return updateColumnInProduct("CATEGORY_CODE",id,categoryCode);
    }

    public boolean updateProductMinimalAmount(int id, int amount)
    {
        return updateColumnInProduct("MINIMAL_AMOUNT",id,amount);
    }


    /*
     * This method gets the name of the column the id of the products_price and the new value.
     */
    private boolean updateColumnInProductPrice(String columnName, int id, Object newValue)
    {
        String query = "UPDATE PRODUCTS_PRICE SET ? = ? WHERE ID = ?";
        try {
            PreparedStatement _ps = connection.prepareStatement(query);
            _ps.setString(1, columnName);
            _ps.setObject(2, newValue);
            _ps.setInt(3, id);
            _ps.executeUpdate();

            return true;

        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }


    /* DATA FOR PRICES */

    public boolean updateBuyPrice(int id,int price)
    {
        return updateColumnInProductPrice("PRICE_COST",id,price);
    }

    public boolean updateSellPrice(int id,int price)
    {
        return updateColumnInProductPrice("PRICE_SELL",id,price);
    }

    public boolean updateStartDate(int id,Date start)
    {
        return updateColumnInProductPrice("DATE_START",id,start);
    }

    public boolean updateEndDate(int id,Date end)
    {
        return updateColumnInProductPrice("DATE_END",id,end);
    }

    public boolean updateProductDiscount(int id,int discount)
    {
        return updateColumnInProductPrice("DISCOUNT",id,discount);
    }

    public boolean updateCategoryDiscount(int id,int discount)
    {
        //TODO:: its the most complicated thing cuz we need to update discount to all the products in the sub-category of this one's id..
        return false;
    }
}
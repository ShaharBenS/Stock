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
    Product_Data(Connection c)
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
            products = new Products();

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

    public boolean updateProductId(int id)
    {
        return true;
    }

    public boolean updateProductLocation(String location)
    {
        return true;
    }

    public boolean updateProductManufacture(String manufacture)
    {
        return true;
    }

    public boolean updateProductCurrentAmount(int amount)
    {
        return true;
    }

    public boolean updateProductAmountInWarehouse(int amount)
    {
        return true;
    }

    public boolean updateProductAmountInStore(int amount)
    {
        return true;
    }

    public boolean updateProductDefectAmount(int amount)
    {
        return true;
    }

    public boolean updateProductCategoryCode(int categoryCode)
    {
        return true;
    }

    /* DATA FOR PRICES */

    public boolean updateBuyPrice(int price)
    {
        return true;
    }

    public boolean updateSellPrice(int price)
    {
        return true;
    }

    public boolean updateStartDate(Date start)
    {
        return true;
    }

    public boolean updateEndDate(Date end)
    {
        return true;
    }

    public boolean updateProductDiscount(int discount)
    {
        return true;
    }
}
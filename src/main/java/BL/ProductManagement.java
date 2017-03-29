package BL;

import SharedClasses.Products;

import java.util.Date;

/**
  * Created by Shahar on 29/03/17.
 */
public class ProductManagement
{
 /* DATE FOR REGULAR PROPERTIES */

    // ADD NEW PRODUCT TO DATABASE
    public boolean addProduct(Products p)
    {
        return true;
    }

    //RETURN PRODUCT FROM DATABASE IF EXISTS, ELSE RETURN NULL
    public Products getProduct(int id)
    {
        return null;
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

}
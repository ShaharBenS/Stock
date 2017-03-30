package BL;

import DAL.Category_Data;
import DAL.Product_Data;
import SharedClasses.Category;

import java.util.Date;

/**
 * Created by Shahar on 29/03/17.
 */
 public class PriceManagement
{
    private Product_Data _PD;

    public PriceManagement(Product_Data pd)
    {
        _PD = pd;
    }

    /* DATA FOR PRICES */

    public boolean updateBuyPrice(int id,int price)
    {
        return true;
    }

    public boolean updateSellPrice(int id,int price)
    {
        return true;
    }

    public boolean updateStartDate(int id,Date start)
    {
        return true;
    }

    public boolean updateEndDate(int id,Date end)
    {
        return true;
    }

    public boolean updateProductDiscount(int id,int discount)
    {
        return true;
    }
}

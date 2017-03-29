package PL;

import BL.CategoryManagement;
import BL.PriceManagement;
import BL.ProductManagement;

/**
 * Created by Shahar on 29/03/17.
 */
public class InputParser
{
    private CategoryManagement CM;
    private PriceManagement priceM;
    private ProductManagement productM;

    InputParser(CategoryManagement cm,PriceManagement price_m,ProductManagement product_m)
    {
        CM = cm;
        priceM = price_m;
        productM = product_m;
    }


}

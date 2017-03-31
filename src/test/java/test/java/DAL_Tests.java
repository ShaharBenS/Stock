package test.java;

import DAL.*;
import Launcher.ProgramLauncher;
import SharedClasses.Category;
import SharedClasses.Products;
import org.junit.*;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Shahar on 29/03/17.
 */
public class DAL_Tests
{
    Product_Data PD;
    Category_Data CD;
    Connection connection = null;
    @Before public void setUp()
    {
        connection = ProgramLauncher.getConnectionAndInitDatabase("tests.db");
        PD = new Product_Data(connection);
        CD = new Category_Data(connection);
    }
    /**
     * TESTING
     * CATEGORY :
     *
     */
    @Test public void category_testInsertion()
    {
        Category c1 = new Category(0,"CATEGORY_0");
        Category c2 = new Category(1,"CATEGORY_1",0);

        if((!CD.addCategory(c1) | !CD.addCategory(c2)))
        {
            fail("Failed adding c1 and c2 to dataBase");
        }

        assertEquals(CD.getCategory(0).equals(c1),true);
        assertEquals(CD.getCategory(1).equals(c2),true);

    }
    @Test public void category_testUpdate()
    {
        Category c1 = new Category(0, "CATEGORY_0");
        CD.addCategory(c1);
        c1.setName("CATEGORY_NEW_0");

        if(!CD.updateCategoryName(0,"CATEGORY_NEW_0"))
        {
            fail("Failed updating name");
        }
        assertEquals(CD.getCategory(0).equals(c1),true);
    }


    /**
     * TESTING
     * PRODUCTS AND PRODUCTS PRICE:
     *
     */
    @Test public void products_testInsertion()
    {
        Products p1 = new Products(0,"LOCATION-0","MANUFACTURE-0",
                5,10,2,0,5,10);


        if(!PD.addProduct(p1))
        {
            fail("Failed adding producs");
        }

        assertEquals(PD.getProduct(0).equals(p1),true);


    }
    @Test public void products_testDeletion()
    {

    }
    @Test public void products_testUpdate()
    {

    }
    @Test public void price_testUpdate()
    {

    }

    @Test public void test_getAllDefectProducts()
    {
        Category c1 = new Category(0, "CATEGORY_0");
        CD.addCategory(c1);

        Products p1 = new Products(0,"LOCATION-0","MANUFACTURE-0",
                5,10,2,0,5,10);
        p1.setDefectAmount(2);
        p1.setAmountInStore(p1.getAmountInStore()-p1.getDefectAmount());
        p1.setCurrentAmount(p1.getAmountInWarehouse()+p1.getAmountInStore()+p1.getDefectAmount());

        Products p2 = new Products(1,"LOCATION-1","MANUFACTURE-1",
                3,5,2,0,2,10);
        p2.setDefectAmount(2);
        p2.setAmountInStore(p2.getAmountInStore()-p2.getDefectAmount());
        p2.setCurrentAmount(p2.getAmountInWarehouse()+p2.getAmountInStore()+p2.getDefectAmount());

        PD.addProduct(p1);
        PD.addProduct(p2);

        Products [] products = PD.getAllDefectProducts();
        assertEquals(products[0].equals(p1),true);
        assertEquals(products[1].equals(p2),true);

    }

    @After public void  tearDown() throws SQLException {
        connection.close();
        connection = null;
        PD = null;
        CD = null;
        File db = new File("tests.db");
        db.delete();
    }
}

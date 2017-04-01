package test.java;

import BL.ProductManagement;
import DAL.Category_Data;
import DAL.Product_Data;
import Launcher.ProgramLauncher;
import SharedClasses.Category;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Shahar on 29/03/17.
 */
public class BLTester {

    Product_Data PD;
    Category_Data CD;

    ProductManagement PM;

    Connection connection = null;

    @Before
    public void setUp()
    {
        connection = ProgramLauncher.getConnectionAndInitDatabase("tests_bl.db");
        PD = new Product_Data(connection);
        CD = new Category_Data(connection);
        PM = new ProductManagement(PD);
    }

    @Test
    public void category_testInsertion()
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

}

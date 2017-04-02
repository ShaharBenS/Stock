package test.java;

import BL.CategoryManagement;
import BL.ProductManagement;
import DAL.Category_Data;
import DAL.Product_Data;
import Launcher.ProgramLauncher;
import SharedClasses.Category;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Shahar on 29/03/17.
 */
public class BLTester {

    Product_Data PD;
    Category_Data CD;

    ProductManagement PM;
    CategoryManagement CM;

    Connection connection = null;

    @Before
    public void setUp()
    {
        connection = ProgramLauncher.getConnectionAndInitDatabase("tests.db");
        PD = new Product_Data(connection);
        CD = new Category_Data(connection);
        PM = new ProductManagement(PD);
        CM = new CategoryManagement(CD,PD);
    }

    @Test
    public void category_testInsertion()
    {
        String c1 = "100 CATEGORY_0";
        String c2 = "101 CATEGORY_1 100";
        if((!CM.addCategory(c1) | !CM.addCategory(c2)))
        {
            fail("Failed adding c1 and c2 to dataBase");
        }

        assertEquals(CD.getCategory(100).equals(new Category(c1)),true);
        assertEquals(CD.getCategory(101).equals(new Category(c2)),true);

    }

    @After
    public void  tearDown() throws SQLException {
        connection.close();
        connection = null;
        PD = null;
        CD = null;
        CM = null;
        PM = null;
        File db = new File("tests.db");
        db.delete();
    }

}

package Launcher;

import BL.CategoryManagement;
import BL.PriceManagement;
import BL.ProductManagement;
import DAL.Category_Data;
import DAL.Product_Data;
import PL.InputReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Shahar on 28/03/17.
 */
public class ProgramLauncher
{
    public static void main ( String [] args ) {
        //Initializing all layers. And DataBase
        Connection conn = getConnectionAndInitDatabase("stock.db");


        //DAL
        Category_Data categoryData = new Category_Data(conn);
        Product_Data productData = new Product_Data(conn);

        //BL
        CategoryManagement categoryManagement = new CategoryManagement(categoryData, productData);
        PriceManagement priceManagement = new PriceManagement(productData);
        ProductManagement productManagement = new ProductManagement(productData);

        //PL
        InputReader inputReader = new InputReader(productManagement,priceManagement,categoryManagement);
        inputReader.start();

        //Close
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnectionAndInitDatabase(String dataBaseName)
    {
        Connection c = null;
        Statement stmt = null;
        try {
            /*Opening Connection*/
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:"+dataBaseName);

            c.createStatement().execute("PRAGMA FOREIGN_KEYS = ON;");

            /*Creating Tables if they are NOT existed */
            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS CATEGORY " +
                        "(ID INT PRIMARY KEY     NOT NULL ," +
                        " NAME           CHAR(50) NOT NULL, " +
                        " ID_FATHER  INT DEFAULT NULL REFERENCES CATEGORY(ID) ON UPDATE CASCADE ON DELETE SET NULL);";
            stmt.executeUpdate(sql);

            stmt.close();

            stmt = c.createStatement();
            sql =   "CREATE TABLE IF NOT EXISTS PRODUCTS " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " LOCATION       CHAR(50)  NOT NULL, " +
                    " MANUFACTURE    CHAR(50)  NOT NULL, " +
                    " AMOUNT_STORE   INT     NOT NULL, " +
                    " AMOUNT_STORAGE INT     NOT NULL," +
                    " AMOUNT_DEFECT  INT     NOT NULL," +
                    " MINIMAL_AMOUNT INT     NOT NULL," +
                    " CATEGORY_CODE  INT      ," +
                    " FOREIGN KEY(CATEGORY_CODE) REFERENCES CATEGORY(ID) ON UPDATE CASCADE ON DELETE SET NULL);";
            stmt.executeUpdate(sql);
            stmt.close();

            stmt = c.createStatement();
            sql =   "CREATE TABLE IF NOT EXISTS PRODUCTS_PRICE " +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    " PRICE_COST     INT    NOT NULL, " +
                    " PRICE_SELL     INT     NOT NULL, " +
                    " DISCOUNT       INT CHECK(DISCOUNT >= 0 AND DISCOUNT <=100), " +
                    " DATE_START     DATE," +
                    " DATE_END       DATE," +
                    " FOREIGN KEY(ID) REFERENCES  PRODUCTS(ID) ON UPDATE CASCADE ON DELETE CASCADE );";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return c;
    }
}

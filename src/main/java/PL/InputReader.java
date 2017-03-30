package PL;

import BL.ProductManagement;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.Scanner;

/**
 * Created by Shahar on 29/03/17.
 */
public class InputReader
{
    private Scanner scanner = new Scanner(System.in);
    private InputParser IP;
    private ProductManagement ProductM;

    private final String[] MENU = {"Choose an option:" ,
                                    "1) Add new Product" ,
                                    "2) Add new Category" ,
                                    "** CATEGORY SECTION **" ,
                                    "3) Update category ID" ,
                                    "4) Update category Name" ,
                                    "5) Update category Father ID" ,
                                    "** PRODUCT SECTION **" ,
                                    "6) Update product ID" ,
                                    "7) Update product Location" ,
                                    "8) Update product Manufacture" ,
                                    "9) Update product Current Amount" ,
                                    "10) Update product Amount in Store" ,
                                    "11) Update product Amount in Warehouse",
                                    "12) Update product Minimal Amount" ,
                                    "13) Update product Amount of Defects" ,
                                    "14) Update product Category Code" ,
                                    "15) Update product Buy Price" ,
                                    "16) Update product Sell Price" ,
                                    "17) Update product Discount (%)" ,
                                    "18) Update product Date Start Discount" ,
                                    "19) Update product Date End Discount" ,
                                    "** OTHER USEFUL OPERATIONS **",
                                    "20) Add new Discount",
                                    "21) Stock report by product ID",
                                    "22) Stock report by category/ies",
                                    "23) Defect products report",
                                    "24) Show all products"};

    public InputReader(InputParser ip, ProductManagement pm)
    {
        this.IP = ip;
        this.ProductM = pm;
    }

    /*
        This method starts reading input and passing it the InputParser.
        stops when user wishes to stop.
     */
    void start()
    {
        int operation;

        while(true)
        {
             for(int i=0; i<MENU.length; i++)
             {
                 System.out.print(MENU[i]+"\n");
             }
             try { operation = scanner.nextInt(); }
             catch(Exception r) { System.out.print("Invalid operation. Please try again\n\n"); continue; }

             switch(operation)
             {
                 case 1:
                     System.out.print("Enter the Products properties (separated by 1 space!) in the following structure:\n" +
                             "[ID] [LOCATION] [MANUFACTURE] [CURRENT AMOUNT] [MINIMAL AMOUNT] [CATEGORY CODE] [BUY PRICE] [SELL PRICE]\n");
                     String productLine = scanner.nextLine();
                     ProductM
                     break;
                 case 2:
                     break;
                 case 3:
                     break;
                 case 4:
                     break;
                 case 5:
                     break;
                 case 6:
                     break;
                 case 7:
                     break;
                 case 8:
                     break;
                 case 9:
                     break;
                 case 10:
                     break;
                 case 11:
                     break;
                 case 12:
                     break;
                 case 13:
                     break;
                 case 14:
                     break;
                 case 15:
                     break;
                 case 16:
                     break;
                 case 17:
                     break;
                 case 18:
                     break;
                 case 19:
                     break;
                 case 20:
                     break;
                 case 21:
                     break;
                 case 22:
                     break;
                 case 23:
                     break;
                 case 24:
                     break;

             }
            //Read Input:
        }
    }
}

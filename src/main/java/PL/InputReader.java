package PL;

import BL.CategoryManagement;
import BL.PriceManagement;
import BL.ProductManagement;
import java.util.Scanner;


public class InputReader
{
    private Scanner scanner = new Scanner(System.in);
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
                                    "** OTHER USEFUL OPERATIONS **",
                                    "17) Add new Discount",
                                    "18) Stock report by product ID",
                                    "19) Stock report by category/ies",
                                    "20) Defect products report",
                                    "21) Show all products",
                                    "22) Exit"};

    public InputReader(ProductManagement pm, PriceManagement price_m, CategoryManagement cm)
    {
        this.ProductM = pm;
    }

    /*
        This method starts reading input and
        stops when user wishes to stop.
     */
    public void start()
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

             String prop;
             switch(operation)
             {
                 case 1:
                     System.out.print("Enter the Products properties (separated by 1 space!) in the following structure:\n" +
                             "[ID] [LOCATION] [MANUFACTURE] [CURRENT AMOUNT] [MINIMAL AMOUNT] [CATEGORY CODE] [BUY PRICE] [SELL PRICE]\n");
                     String productLine = scanner.nextLine();
                     if(ProductM.addProduct(productLine))
                         System.out.print(" >> Product added successfully\n");
                     else System.out.print(" >> Invalid arguments. Try again\n");
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
                     System.out.print("Enter properties in the following structure:\n" +
                             "[ID] [NEW ID]\n");
                     prop = scanner.nextLine();
                     printUpdate(ProductM.updateProductId(prop));
                     break;
                 case 7:
                     System.out.print("Enter properties in the following structure:\n" +
                             "[ID] [NEW LOCATION]\n");
                     prop = scanner.nextLine();
                     printUpdate(ProductM.updateProductLocation(prop));
                     break;
                 case 8:
                     System.out.print("Enter properties in the following structure:\n" +
                             "[ID] [NEW MANUFACTURE]\n");
                     prop = scanner.nextLine();
                     printUpdate(ProductM.updateProductManufacture(prop));
                     break;
                 case 9:
                     /*System.out.print("Enter properties in the following structure:\n" +
                             "[ID] [NEW CURRENT AMOUNT]\n");
                     prop = scanner.nextLine();
                     printUpdate(ProductM.updateProductCurrentAmount(prop));*/
                     break;
                 case 10:
                     System.out.print("Enter properties in the following structure:\n" +
                             "[ID] [NEW AMOUNT IN WAREHOUSE]\n");
                     prop = scanner.nextLine();
                     printUpdate(ProductM.updateProductAmountInWarehouse(prop));
                     break;
                 case 11:
                     System.out.print("Enter properties in the following structure:\n" +
                             "[ID] [NEW AMOUNT IN STORE]\n");
                     prop = scanner.nextLine();
                     printUpdate(ProductM.updateProductAmountInStore(prop));

                     break;
                 case 12:
                     System.out.print("Enter properties in the following structure:\n" +
                             "[ID] [NEW MINIMAL AMOUNT]\n");
                     prop = scanner.nextLine();
                     printUpdate(ProductM.updateProductMinimalAmount(prop));
                     break;
                 case 13:
                     System.out.print("Enter properties in the following structure:\n" +
                             "[ID] [NEW AMOUNT OF DEFECTS]\n");
                     prop = scanner.nextLine();
                     printUpdate(ProductM.updateProductDefectAmount(prop));
                     break;
                 case 14:
                     System.out.print("Enter properties in the following structure:\n" +
                             "[ID] [NEW CATEGORY CODE]\n");
                     prop = scanner.nextLine();
                     printUpdate(ProductM.updateProductCategoryCode(prop));
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
                     return; // EXITING!

             }
            //Read Input:
        }
    }

    private void printUpdate(boolean arg)
    {
        if(arg) System.out.print(" >> Product updated successfully\n");
        else System.out.print(" >> Invalid arguments. Try again\n");
    }
}

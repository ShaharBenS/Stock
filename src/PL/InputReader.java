package PL;

import java.util.Scanner;

/**
 * Created by Shahar on 29/03/17.
 */
public class InputReader
{
    private Scanner scanner = new Scanner(System.in);
    private InputParser IP;

    InputReader(InputParser ip)
    {
        IP = ip;
    }

    /*
        This method starts reading input and passing it the InputParser.
        stops when user wishes to stop.
     */
    void start()
    {
        while(true)
        {
            //Read Input:
        }
    }
}

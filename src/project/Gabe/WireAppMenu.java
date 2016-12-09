package project.Gabe;

import java.util.Scanner;
import utilities.Prompt;
//import project.Gabe.WireApp2;

/**
 *
 * @author Gabriel Ulrich
 */
public class WireAppMenu {

    Scanner sc = new Scanner(System.in);
    WireList data = new WireList();

    public WireAppMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        String wireTypes;
        String toolTypes;
        double timeWorked;
        double price;

        while (choice != 0) {
            System.out.println("\nWire App");
            System.out.println("==========================");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            
            System.out.println("6 = Retrieve All: order by ID");
            System.out.println("7 = Retrieve All: order by wire types");
            System.out.println("8 = Retrieve All: order by price in descending order");
            System.out.println("9 = Retrieve All: order by tool types");
            System.out.println("10 = Retrieve All: order by time worked");
            System.out.println("11 = Retrieve All: order by time worked and price in desecnding order");
            System.out.println("12 = Statistics");
            
            choice = Prompt.getInt("Number of choice: ", 0, 12);
//----------------------------------------------------------------------------
            if (choice == 1) {
                System.out.println(data.toString());
//----------------------------------------------------------------------------
            } else if (choice == 2) {
                id = Prompt.getInt("Enter Wire id: ");
                wireTypes = Prompt.getLine("Enter wire type: ");
                toolTypes = Prompt.getLine("Enter tool type: ");
                timeWorked = Prompt.getDouble("Enter time worked: ");
                price = Prompt.getDouble("Enter price: ");
                Wire wire = new Wire(id, wireTypes, toolTypes, timeWorked, price);
                data.create(wire);
//----------------------------------------------------------------------------                
            } else if (choice == 3) {
                id = Prompt.getInt("Enter wire id: ");
                System.out.println(data.retrieve(id));
//----------------------------------------------------------------------------                
            } else if (choice == 4) {
                ;
//----------------------------------------------------------------------------               
            } else if (choice == 5) {
                id = Prompt.getInt("Enter wire id: ");
                System.out.println("***WIRE PROJECT DELETED***");
                data.delete(id);
//----------------------------------------------------------------------------                
            } else if (choice == 6) {
                System.out.println(data.oderById());
//----------------------------------------------------------------------------                
            } else if (choice == 7) {
                System.out.println(data.oderByWireTypes());
//----------------------------------------------------------------------------                
            } else if (choice == 8) {
                System.out.println(data.oderByPrice());
//----------------------------------------------------------------------------                
            } else if (choice == 9) {
                System.out.println(data.oderByToolypes());
//----------------------------------------------------------------------------                
            } else if (choice == 10) {
                System.out.println(data.oderByTimeWorked());
//----------------------------------------------------------------------------                
            } else if (choice == 11) {
                System.out.println(data.oderByTimeWorkedPrice());
//----------------------------------------------------------------------------
            } else if (choice == 12) {
                System.out.println(String.format("%20s %20s %20s %20s %35s %n", "[Addition of Prices]", "[Average Price]", "[Minimum Price]", "[Maximum Price]", "[Standard Deviation of Prices]"));
                System.out.println(data.priceStatistics());
//----------------------------------------------------------------------------                
            } else if (choice == 0) {
                System.out.println("***SEE YOU NEXT TIME***");
                ;
            }
        }
    }

    public static void main(String[] args) {
        new WireAppMenu();
    }
}

package com.blz.stockportfolio;

import java.util.ArrayList;
import java.util.Scanner;

public class StockPortfolio {
    ArrayList<Stock> listOfStocks = new ArrayList<>();
    public static int bal = 100000;

    static Scanner sc = new Scanner(System.in);

    public StockPortfolio(ArrayList<Stock> listOfStocks) {

        this.listOfStocks = listOfStocks;
    }

    public StockPortfolio() {
        super();
    }

    public void addPortfolio(Stock stock) {

        this.listOfStocks.add(stock);

    }

    public void displayPortfolio() {
        System.out.println("\nDisplaying Stock Portfolio...\n");
        System.out.println("STOCKS\tSHARES\tPRICE\tVALUE");
        for(Stock stockToPrint : this.listOfStocks) {
            System.out.println(stockToPrint.getNames() + "\t" + stockToPrint.getNoOfShares() + "\t" + stockToPrint.getSharePrice() + "\t" + stockToPrint.getValue());
        }
    }

    public void displayStockReport() {

        System.out.println("***Stock Report***");
        displayPortfolio();
        System.out.println("Total Stock Value : $" + calculateTotalValue());
    }

    public int calculateTotalValue() {

        int totalValue = 0;
        for(Stock stock : this.listOfStocks){
            totalValue += stock.getValue();
        }
        return totalValue;
    }

    public void withdraw() {

        System.out.println("Balance is : $" + bal);
        System.out.println("How much amount you wanna withdraw? : ");
        int debt = sc.nextInt();
        if(bal - debt > 0) {
            bal = bal - debt;
            System.out.println("Withdrawl successful!");
            System.out.println("Balance : $" + bal);
        }
        else
            System.out.println("Insufficient funds \n Withdrawl limit Exceeded");
    }

    public int getChoice() {

        int input = 0;

        while(!(input >= 1 && input <= 4)) {

            System.out.println("You wanna ? ");
            System.out.println(" 1) Add Stock \n 2) Display Stock Report \n 3) Withdraw Amount \n 4) Exit");
            System.out.println("Your choice? : ");
            input = sc.nextInt();
        }
        return input;
    }

    public void selectChoice() {

        int choice = 0;
        while (choice != 4) {

            choice = getChoice();

            switch (choice) {

                case 1:
                    Stock s = new Stock();
                    s.addStocks(new StockPortfolio(listOfStocks));
                    break;

                case 2:
                    displayStockReport();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    System.out.println("Exited!");
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }

        }
    }
}

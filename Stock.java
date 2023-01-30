package com.blz.stockportfolio;

import java.util.Scanner;

public class Stock {
    static Scanner sc = new Scanner(System.in);
    String names;
    int noOfShares;
    int sharePrice;
    int value;

    public Stock(String names, int noOfShares, int sharePrice, int value) {

        super();
        this.names = names;
        this.noOfShares = noOfShares;
        this.sharePrice = sharePrice;
        this.value = value;
    }

    public Stock() {

    }

    public String getNames() {

        return names;
    }

    public int getNoOfShares() {

        return noOfShares;
    }

    public int getSharePrice() {

        return sharePrice;
    }

    public int getValue() {

        return value;
    }

    public void addStocks(StockPortfolio portfolio) {

        System.out.println("Enter number of stocks in portfolio : ");
        int noOfStocks = sc.nextInt();

        for (int i = 0; i < noOfStocks; i++) {
            System.out.println("Stock - " + (i + 1));
            System.out.println("Name of stock? : ");
            String name = sc.next();
            System.out.println("Number of shares? : ");
            int shares = sc.nextInt();
            System.out.println("Share price? : ");
            int price = sc.nextInt();
            int value = calculateStockValue(shares, price);

            Stock stock = new Stock(name, shares, price, value);
            portfolio.addPortfolio(stock);

        }
    }
    public int calculateStockValue(int shares, int stockPrice) {

        return(shares * stockPrice);
    }
}

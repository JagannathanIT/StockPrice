package com.Stock;


import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockPrice {

public BigDecimal findSymbolPrice(String Symbol)
{
BigDecimal price=null;
Stock stock = YahooFinance.get(Symbol);
price = stock.getQuote().getPrice();
return price;
}

public void findTopStockHolders()
{
	
  	 System.out.println("Enter Text file location"); 
    try {
       Scanner input = new Scanner(System.in);
       String fin=input.nextLine();
       FileInputStream fis = new FileInputStream(fin);
       NavigableMap<BigDecimal, String> hm = new TreeMap<BigDecimal, String>();
   	//Construct BufferedReader from InputStreamReader
   	BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    
   	String line = "",temp="";
   	while ((line = br.readLine()) != null) {
   		BigDecimal totalStock=new BigDecimal(0);
   		String[] parts=null,parts1=null;
   		temp=line.replaceAll("\\s+",""); 
   		parts = temp.split(",");
   		for(int i=0;i<parts.length;i++){
   		 parts1 = parts[i].split("-");
         StockPrice sp= new StockPrice();
   		totalStock = totalStock.add(sp.findSymbolPrice(parts1[0]).multiply(new BigDecimal( parts1[1])));   				

   		}
   		
   		 hm.put(totalStock, line );
   	    
   	}
   
    hm=hm.descendingMap();
   	for(Map.Entry<BigDecimal,String> entry : hm.entrySet()) {
   		BigDecimal key = entry.getKey();
   		  String value = entry.getValue();

   		  System.out.println(value + " => $" +key);
   		}
   	 


   	br.close();
   } catch (Exception ex) {
       System.out.println(ex);
       return;
       }
   }

	
	

	
	public static void main(String[] args)  {
		
		 StockPrice sp= new StockPrice();
         sp.findTopStockHolders();
    

}
}

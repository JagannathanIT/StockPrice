package com.Stock;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class TestStock {

      StockPrice sp= new StockPrice();

	   //test to check appraisal
	   @Test
	   public void testFindSymbolPrice() {

			
	      BigDecimal price = sp.findSymbolPrice("GOOG");
	      System.out.println(price);
	      int bd1 =(int) 806.15;
	      assertEquals(bd1, price.intValue());
	   }




	}
package com.griffin.lambda;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class MapReduce {

	/* Create a list of Invoices, and use map().reduce() to sum the total price*qty value
  			class Invoice {
	 			 String invoiceNo;
	  			 BigDecimal price;
	  			 BigDecimal qty;
	  			 }
   */
	public static void main(String... args) {

		List<Invoice> invoiceList = Arrays.asList(
				new Invoice("Phil", BigDecimal.valueOf(100.3), BigDecimal.valueOf(3)),
				new Invoice("Phil", BigDecimal.valueOf(200.3), BigDecimal.valueOf(2)),
				new Invoice("Phil", BigDecimal.valueOf(300.3), BigDecimal.valueOf(1))
		);

		// Function() accepts an Invoice and returns a computed total
		Function<Invoice, BigDecimal> invoiceBigDecimalFunction = (inv) -> {
			return inv.qty.multiply(inv.price);
		};

		// Reduce()
		// Note BigDecimal::add performs accumulator function.
		BigDecimal invTotal = invoiceList.stream().map(invoiceBigDecimalFunction).reduce(BigDecimal.ZERO, BigDecimal::add);

		System.out.println("total " + invTotal);
	}

	public static class Invoice {
		String invoiceName;

		BigDecimal price;

		BigDecimal qty;

		Invoice(String name, BigDecimal price, BigDecimal qty) {
			this.invoiceName = name;
			this.price = price;
			this.qty = qty;
		}
	}

}

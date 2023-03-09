package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class CurrencyExchangeCalc {

    BigDecimal sumAllPricesInEuro(ArrayList<Product> products, ArrayList<Currency> currencies) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product product : products) {
            for (Currency currency : currencies) {
                if (product.getCurrency().equals(currency.getName())) {
                    BigDecimal exchange = product.getPrice().divide(currency.getRate(), RoundingMode.UP);
                    sum = sum.add(exchange);
                }
            }
        }
        return sum;
    }

    BigDecimal calAvgPriceInEuro(BigDecimal sumPricesInEuro, int productsQuantity) {
        return sumPricesInEuro.divide(BigDecimal.valueOf(productsQuantity), RoundingMode.UP);
    }

    Product getTheMostExpensiveOne(ArrayList<Product> products, ArrayList<Currency> currencies) {
        BigDecimal theMostExpensive = BigDecimal.ZERO;
        Product product = null;
        for (Product value : products) {
            for (Currency item : currencies) {
                if (value.getCurrency().equals(item.getName())) {
                    BigDecimal exchange = value.getPrice().divide(item.getRate(), RoundingMode.UP);
                    if (exchange.compareTo(theMostExpensive) > 0) {
                        theMostExpensive = exchange;
                        String name = value.getName();
                        BigDecimal price = value.getPrice();
                        String currency = value.getCurrency();
                        product = new Product(name, price, currency);
                    }
                }
            }
        }
        return product;
    }

    Product getTheCheapestOne(ArrayList<Product> products, ArrayList<Currency> currencies) {
        BigDecimal theCheapestOne = BigDecimal.valueOf(1000000000);
        Product product = null;
        for (Product value : products) {
            for (Currency item : currencies) {
                if (value.getCurrency().equals(item.getName())) {
                    BigDecimal exchange = value.getPrice().divide(item.getRate(), RoundingMode.UP);
                    if (exchange.compareTo(theCheapestOne) < 0) {
                        theCheapestOne = exchange;
                        String name = value.getName();
                        BigDecimal price = value.getPrice();
                        String currency = value.getCurrency();
                        product = new Product(name, price, currency);
                    }
                }
            }
        }
        return product;
    }
}

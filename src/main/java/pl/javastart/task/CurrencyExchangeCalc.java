package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CurrencyExchangeCalc {

    BigDecimal sumAllPricesInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product product : products) {
            Currency currency = findCurrencyByName(product.getCurrency(), currencies);
            BigDecimal exchange = product.getPrice().divide(currency.getRate(), RoundingMode.UP);
            sum = sum.add(exchange);
        }
        return sum;
    }

    private Currency findCurrencyByName(String name, List<Currency> currencies) {
        Currency currency = new Currency();
        for (Currency value : currencies) {
            if (value.getName().equals(name)) {
                currency.setName(value.getName());
                currency.setRate(value.getRate());
            }
        }
        return currency;
    }

    BigDecimal calAvgPriceInEuro(BigDecimal sumPricesInEuro, int productsQuantity) {
        return sumPricesInEuro.divide(BigDecimal.valueOf(productsQuantity), RoundingMode.UP);
    }

    Product getTheMostExpensiveOne(List<Product> products, List<Currency> currencies) {
        BigDecimal theMostExpensive = BigDecimal.ZERO;
        Product product = null;
        for (Product value : products) {
            Currency currency = findCurrencyByName(value.getCurrency(), currencies);
            BigDecimal exchange = value.getPrice().divide(currency.getRate(), RoundingMode.UP);
            if (exchange.compareTo(theMostExpensive) > 0) {
                theMostExpensive = exchange;
                String name = value.getName();
                BigDecimal price = value.getPrice();
                String currency1 = value.getCurrency();
                product = new Product(name, price, currency1);
            }
        }
        return product;
    }

    Product getTheCheapestOne(List<Product> products, List<Currency> currencies) {
        BigDecimal theCheapestOne = BigDecimal.valueOf(1000000000);
        Product product = null;
        for (Product value : products) {
            Currency currency = findCurrencyByName(value.getCurrency(), currencies);
            BigDecimal exchange = value.getPrice().divide(currency.getRate(), RoundingMode.UP);
            if (exchange.compareTo(theCheapestOne) < 0) {
                theCheapestOne = exchange;
                String name = value.getName();
                BigDecimal price = value.getPrice();
                String currency1 = value.getCurrency();
                product = new Product(name, price, currency1);
            }
        }
        return product;
    }
}

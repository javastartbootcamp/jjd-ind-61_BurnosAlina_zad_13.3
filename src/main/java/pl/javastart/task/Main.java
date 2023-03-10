package pl.javastart.task;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        final String fileName1 = "src/main/resources/currencies.csv";
        final String fileName2 = "src/main/resources/products.csv";
        ProductAndCurrencyReader reader = new ProductAndCurrencyReader();
        CurrencyExchangeCalc calc = new CurrencyExchangeCalc();
        try {
            List<Product> products = reader.readProductFile(fileName2);
            List<Currency> currencies = reader.readCurrenciesFile(fileName1);
            BigDecimal sumPricesInEuro = calc.sumAllPricesInEuro(products, currencies);
            System.out.println("Suma cen wszystkich produktów w EURO: " + sumPricesInEuro);
            BigDecimal avgPriceInEuro = calc.calAvgPriceInEuro(sumPricesInEuro, products.size());
            System.out.println("Średnia cena produktu w EURO: " + avgPriceInEuro);
            Product theMostExpensiveOne = calc.getTheMostExpensiveOne(products, currencies);
            System.out.println("Najdroższy produkt w przeliczeniu na EURO: " + theMostExpensiveOne);
            Product theCheapestOne = calc.getTheCheapestOne(products, currencies);
            System.out.println("Najtańszy produkt w przeliczeniu na EURO: " + theCheapestOne);
        } catch (IOException e) {
            System.err.println("Nie udało się odczytać pliku.");
        }
    }
}

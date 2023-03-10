package pl.javastart.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductAndCurrencyReader {
    List<Product> readProductFile(String fileName) throws IOException {
        List<Product> productList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(";");
            String name = words[0];
            BigDecimal price = new BigDecimal(words[1]);
            String currency = words[2];
            productList.add(new Product(name, price, currency));
        }
        return productList;
    }

    List<Currency> readCurrenciesFile(String fileName) throws IOException {
        List<Currency> currencyList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(";");
            String name = words[0];
            BigDecimal rate = new BigDecimal(words[1]);
            currencyList.add(new Currency(name, rate));
        }
        return currencyList;
    }
}
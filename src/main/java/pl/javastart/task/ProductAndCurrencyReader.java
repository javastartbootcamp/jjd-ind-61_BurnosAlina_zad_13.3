package pl.javastart.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

public class ProductAndCurrencyReader {
    ArrayList<Product> readProductFile(String fileName) throws IOException {
        ArrayList<Product> productList = new ArrayList<>();
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

    ArrayList<Currency> readCurrenciesFile(String fileName) throws IOException {
        ArrayList<Currency> currencyList = new ArrayList<>();
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
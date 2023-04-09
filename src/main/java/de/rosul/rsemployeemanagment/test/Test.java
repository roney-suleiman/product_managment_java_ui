package de.rosul.rsemployeemanagment.test;

import de.rosul.rsemployeemanagment.logic.ProductHolder;
import de.rosul.rsemployeemanagment.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) {

//        Date exp = new Date("10/11/2028");
//        Date now = new Date();
//        Product p1 = new Product("rrr", 5, 100, 50, now, exp);
//        Product p2 = new Product();
//
//        System.out.println(p1);
//        System.out.println(p2);

//        LocalDate exp = LocalDate.of(2022,01,01);
//        Product product = new Product("tuna",  1, 1, 1, 1,exp);
//
//        System.out.println(product.getValidity());

        for(int i=0; i<ProductHolder.getInstance().products.size(); i++) {

            System.out.println(ProductHolder.getInstance().products.get(i).getName());
        }


    }

//region Konstanten
//endregion

//region Attribute
//endregion

//region Konstruktor
//endregion

//region Methoden

    public static List<Product> getProductData() {
        LocalDate exp = LocalDate.of(2021,12,12);
        List<Product> productList = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Product product = new Product("tuna",  1, 1, 1, 1,exp);
//            Product product = new Product();
            productList.add(product);
        }
        return productList;
    }

//endregion

}

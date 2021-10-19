package com.interview2;

import java.util.Arrays;
import java.util.Scanner;

public class InterviewApplication2 {
    public static void main(String[] args) {

        try {
        Scanner numberOfBooks = new Scanner(System.in);
        System.out.println("Lütfen kitap sayısını giriniz");
        int n = numberOfBooks.nextInt();
        if(n>10 || n<1) {
            System.out.println("Kitap sayısı 1'den küçük 10'dan büyük olamaz!");
        }
        else {
            int[] price = new int[n];
            boolean isValid= true;
            Scanner priceOfBooks = new Scanner(System.in);
            System.out.println("Lütfen Kitap ücretlerini giriniz");
            for(int i=0; i<n; i++) {
                price[i]=priceOfBooks.nextInt();
                if(price[i]> 100 || price[i]<1){
                    isValid = false;
                }
            }
            if(isValid) {
            Scanner budgetInput = new Scanner(System.in);
            System.out.println("Lütfen Bütçeyi giriniz");
            int budget = budgetInput.nextInt();  // Read user input
            if(budget<1 ||  budget> 1000) {
                System.out.println("Bütçe 1'den küçük 1000'den büyük olamaz");
            }
            else {
                System.out.println("Bir seferde alınabilecek max kitap sayısı :" + getMaxBooks(price,budget));
            }
            }
        }
        }
        catch (Exception e) {
            System.out.println("Please Enter Only Numbers");
        }
    }
    public static int getMaxBooks (int[] price, int budget) {
        int maxBooksNumber=0;
        Arrays.sort(price);
        for(int i=0; i< price.length; i++) {
            if(budget > price[i]){
                budget = budget-price[i];
                maxBooksNumber++;
            }
        }
        return maxBooksNumber;
    }
}

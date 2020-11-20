package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number, Y_N;
        String reverseNum = "";
        ArrayList<String> chars = new ArrayList<>();
        ArrayList<Integer> superPrimes = new ArrayList<>();

        do {
            do {
                System.out.print("Write your number (no more then 1000): ");
                number = scanner.nextLine();
            } while (Integer.valueOf(number) > 1000 && Integer.valueOf(number) < 0 );

            superPrimes.clear();


            isPrime isPrime = (num) -> {
                boolean numIsPrime = false, isNotPrime = false;
                int n = num;
                int m = n / 2;

                if(n != 0 && n != 1) {
                    for (int i = 2; i <= m; i++) {
                        if (n % i == 0) {
                            isNotPrime = true;
                            break;
                        }
                    }
                    if (!isNotPrime) {
                        numIsPrime = true;
                    }
                }

                return numIsPrime;
            };

            int maxNum = Integer.valueOf(number);
            for(int i = 0; i < maxNum ; i++) {
                chars.clear();
                reverseNum = "";
                if (isPrime.isPrime(i)) {
                    number = Integer.toString(i);
                    for (int j = 0; j < number.length() ; j++) {
                        chars.add(number.substring(j, j + 1));
                    }
                    for(int j = chars.size() - 1; j >= 0; j--) {
                        reverseNum += chars.get(j);
                    }
                    if (isPrime.isPrime(Integer.valueOf(reverseNum))) {
                        superPrimes.add(i);
                    }
                }
            }

            System.out.println("Super prime numbers between 0 and " + maxNum + ": ");
            for(int i = 0; i < superPrimes.size() ; i++) {
                System.out.print(superPrimes.get(i) + " ");
            }
            System.out.println();
            System.out.println("Super prime numbers count = " + superPrimes.size());

            do {
                System.out.print("Do you want to continue (y/n): ");
                Y_N = scanner.nextLine();
            } while(!Y_N.equals("y") && !Y_N.equals("n"));
            System.out.println();

        } while(Y_N.equals("y"));
        System.out.println();

    }
}

package io.zipcoder;

import java.util.Arrays;
import java.util.Collections;


public class NestedItem {
    private Integer[] arrayOfInts;
    private int primeNumberCount = 0;

    public Integer[] getArrayOfInts() {
        return arrayOfInts;
    }

    public int getPrimeNumberCount() {
        return primeNumberCount;
    }

    public NestedItem(Integer[] arrayOfInts){
        this.arrayOfInts = arrayOfInts;
        countPrimeNumber();
        sortArrayOfIntsDescending();
    }

    private void countPrimeNumber(){
        for (int element : arrayOfInts){
            if (isPrime(element)){
                primeNumberCount ++;
            }
        }
    }

    private void sortArrayOfIntsDescending(){
        Arrays.sort(arrayOfInts, Collections.reverseOrder());
    }

    private boolean isPrime(int n) {
        if(n == 2) return true;
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return Arrays.toString(arrayOfInts);
    }

}


package com.example.practiceapplication;

public class EulerJava {

    //Each new term in the Fibonacci sequence is generated by adding the previous two terms.
//By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
    public long Fib(){
        int fib = 1;
        int priorFib = 0;
        int currentFib = 0;
        int evenFib = 0;
        for(int i = 0; fib <= 4000000; i += 2){
            currentFib = fib;
            fib = fib + priorFib;
            priorFib = currentFib;
            if((fib%2) == 0){
                evenFib += fib;
            }
        }
        return evenFib;
    }
    //A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    //Find the largest palindrome made from the product of two 3-digit numbers.
    public long Palindrome(){
        long HighestPalindrome = 0;
        long CurrentValue = 0;
        for(int i = 999; i > 100; i--){
            for(int y = 999; y > 100; y--){
                CurrentValue = i * y;
                //System.out.println(i + " * " + y + " = " + CurrentValue);
                if(CurrentValue < HighestPalindrome){
                    y = 0;
                }
                if(isPalindrome(CurrentValue)){
                    if(CurrentValue > HighestPalindrome){
                        HighestPalindrome = CurrentValue;
                    }
                }
            }
        }
        return(HighestPalindrome);
    }

    private boolean isPalindrome(long value){
        String reverse = "";
        for (int i = String.valueOf(value).length() - 1; i >= 0; i--){
            reverse += String.valueOf(value).charAt(i);
        }
        boolean isIt = false;
        if(String.valueOf(value).equals(reverse)){
            isIt = true;
            /*if(isIt){
                System.out.println(value + " : " + reverse);
            }*/
        }
        return isIt;
    }

    //The prime factors of 13195 are 5, 7, 13 and 29.
    //What is the largest prime factor of the number 600851475143 ?
    public long PrimeFactor(){
        long largestPrime = 2;
        long FactorNumber = 600851475143L;
        for(long i = 3; i < (FactorNumber / i); i ++){
            if((FactorNumber%i) == 0){
                largestPrime = i;
                FactorNumber /= i;
                if(FactorNumber>1){
                    largestPrime = FactorNumber;
                }
            }
        }
        return (largestPrime);
    }

    //If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    // Find the sum of all the multiples of 3 or 5 below 1000.

    public long SumOfMultiples(){
        int sum = 0;
        for (int i = 3; i < 1000; i++){
            if((i%3) == 0 || (i%5) == 0){
                sum += i;
            }
        }
        return (sum);
    }

    //2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    //What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
    public long smallest(int value){
        long roundedValue = Math.round(((value+0.1)/2) + 1);
        System.out.println(roundedValue);
        long smallest;
        int isDividable = 2;
        for(long i = value; i <= Long.MAX_VALUE; i += value ){
            for(int y = 3; y <= value; y+=2){
                if((i % y) == 0){
                    isDividable += 1;
                }
                else{
                    break;
                }
            }
            if(isDividable == roundedValue){
                smallest = i;
                for(int y = 1; y <= value; y++){
                    if(smallest % y != 0){
                        isDividable = 2;
                        break;
                    }
                }
                if(isDividable == roundedValue){
                    return (smallest);
                }
            }
            else {
                isDividable = 2;
            }
        }
        return 0;
    }
}

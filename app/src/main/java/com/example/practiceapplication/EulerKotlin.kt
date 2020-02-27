package com.example.practiceapplication

class EulerKotlin {
    //Each new term in the Fibonacci sequence is generated by adding the previous two terms.
    //By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
    //By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

    fun fib(MaxValue : Long = 4000000) : Long{
        var fib = 1
        var priorFib = 0
        var currentFib : Int
        var evenFib = 0L
        while(fib <= MaxValue){
            currentFib = fib
            fib = fib + priorFib
            priorFib = currentFib
            if((fib%2) == 0)
                evenFib += fib
        }
        return evenFib
    }

    //If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
    //Find the sum of all the multiples of 3 or 5 below 1000.

    fun sumOfMultiples(Value : Long = 1000) : Long{
        var sum = 0L
        var i = 3
        while(i < Value){
            if((i%3) == 0 || (i%5) == 0){
                sum += i
            }
            i++
        }
        return sum
    }

    //A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    //Find the largest palindrome made from the product of two 3-digit numbers.

    fun palindrome() : Long{
        var highestPalindrome = 0L
        var currentValue: Long
        var i = 999L
        while(i > 100){
            var y = 999L
            while(y > 100){
                currentValue = i * y
                if(currentValue < highestPalindrome){
                    y = 1
                }
                if(isPalindrome(currentValue)){
                    if(currentValue > highestPalindrome){
                        highestPalindrome = currentValue
                    }
                }
                y--
            }
            i--
        }
        return highestPalindrome
                //("$highestPalindrome - is the highest palindrome")


    }
    private fun isPalindrome(value : Long) : Boolean{
        return (value.toString() == value.toString().reversed())
    }

    //The prime factors of 13195 are 5, 7, 13 and 29.
    //What is the largest prime factor of the number 600851475143 ?
    fun primeFactor(_factorNumber : Long = 600851475143L ) : Long{
        var largestPrime = 2L
        var factorNumber = _factorNumber
        var i = 3L
        while(i < (factorNumber / i)){
            if((factorNumber % i) == 0L){
                largestPrime = i
                factorNumber /= i
                if(factorNumber > 1){
                    largestPrime = factorNumber
                }
            }
            i++
        }
        return(largestPrime)
    }
    /*fun small(value : Long = 20) : Long{
        var smallest = 0L
        val values = mutableListOf<Long>(1, 2, 3, 5, 7, 9, 11, 13, 17, 19, 20)
        var isDivisible = 0
        /*for(i in 2 until value step 1){
            for(x in values.size downTo 0 step -1){
                if(values.get(x) % i != 0L){
                    values.add(x.toLong())
                }
            }
        }*/
        for(x in value until 10000000 step value){
            for(integer in values){
                if(x % integer != 0L){
                    isDivisible++;
                }
            }
            if(isDivisible != 0){
                smallest = x
            }
            isDivisible = 0
        }

        return smallest
    }*/

    //2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    //What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
    fun smallest(value : Long = 20) : Long?{
        var roundedValue = Math.round(((value+0.1)/2) + 1)
        var smallest : Long
        var isDividable = 2;
        for(x in value until Long.MAX_VALUE step value){
            loop@for(y in 3 until value step 2){
                if((x % y) == 0L){
                    isDividable += 1
                }
                else{
                    break@loop
                }
            }
            if(isDividable == roundedValue.toInt()){
                smallest = x
                loop@for(y in 1 until value step 1){
                    if((smallest % y).toInt() != 0){
                        isDividable = 2
                        break@loop
                    }
                }
                if(isDividable == roundedValue.toInt()){
                    return (smallest)
                }
            }
            else{
                isDividable = 2
            }
        }
        return(null)
    }
}
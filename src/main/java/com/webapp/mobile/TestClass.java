package com.webapp.mobile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
       // List<String> res = Arrays.asList("amit","sia","mia");
//        List<String> val = res.stream().map(s-> s.toUpperCase()).collect(Collectors.toList());
//        System.out.println(val);
//        List<String> val = res.stream()
//                .map(s->s.substring(0,1).toUpperCase()+s.substring(1))
//                .collect(Collectors.toList());
//        System.out.println(val);

//        List<Integer> res = Arrays.asList(23,24,5,6,86,42,33,28,6,7);
//        List<Integer> val = res.stream().filter(a->a%2==0).sorted().distinct().collect(Collectors.toList());
//        System.out.println(val);

//        List<String> res = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "grape");
//        Map<Object, Long> val=res.stream().collect(Collectors
//                .groupingBy(word -> word,Collectors.counting()));
//        System.out.println(val);

//        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "grape");
//        Map<Object, Long> val = countWordFrequency(words);
//        System.out.println(val);
//    }
//    public static Map<Object, Long> countWordFrequency(List<String> words) {
//        return words.stream()
//                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        List<Integer> str = Arrays.asList(3,4,9,54,57,31,89,103);
        int val = str.stream()
                .filter(TestClass::isPrime).mapToInt(Integer::intValue).sum();


        System.out.println("Prime numbers: "+val);
    }
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

//Write a Java program that finds the sum of all prime numbers within a given range.


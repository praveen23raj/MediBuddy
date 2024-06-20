package com.practo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 10, 2);
        Integer i = list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(i);
    }
}

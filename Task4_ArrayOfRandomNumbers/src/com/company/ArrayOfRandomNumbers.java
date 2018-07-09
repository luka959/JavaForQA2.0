package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfRandomNumbers {
    private static Integer[] array = new Integer[20];
    //макс.отрицательное значение:
    private static int maxNegative = Integer.MIN_VALUE;
    //мин.положительное значение:
    private static int minPositive = Integer.MAX_VALUE;
    //все макс.отрицательные значения:
    private static List<Integer> listMaxNegative = new ArrayList();
    //все мин.положительные значения:
    private static List<Integer> listMinPositive = new ArrayList();


    public static void main(String[] args) {

        zapolnenieArray();

        //находим макс.отрицательное и мин. положительное значения:
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 & array[i] > maxNegative) {
                maxNegative = array[i];
            } else if (array[i] > 0 & array[i] <= minPositive) {
                minPositive = array[i];
            }
        }

        //находим все макс.отрицательные и все мин.положительные значения:
        for (int i = 0; i < array.length; i++) {
            if (maxNegative == array[i]) {
                listMaxNegative.add(array[i]);
            } else if (minPositive == array[i]) {
                listMinPositive.add(array[i]);
            }
        }

        System.out.println("\n" + listMaxNegative.toString() + "\n" + listMinPositive.toString() +
                           "\n" + maxNegative + "\n" + minPositive);

        List<Integer> newList = Arrays.asList(array);
        System.out.println("Заменили все макс.отрицательные значения на все мин.положительные: ");
        for (int i = 0; i < newList.size(); i++) {
            Integer ii = newList.get(i);
            if (ii == maxNegative) {
                ii = minPositive;
            } else if (ii == minPositive) {
                ii = maxNegative;
            }
            System.out.print(ii + "; ");
        }
    }

    public static void zapolnenieArray() {
        System.out.println("Первоначальный массив: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 21) - 10);
            System.out.print(array[i] + "; ");
        }
    }
}

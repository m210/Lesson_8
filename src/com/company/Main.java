package com.company;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        task1();
        checkVersion(0, 2023); //task 2
        task3();
        checkDoubles("abcdefghijkk"); //task 4
        task5();
    }

    public static boolean isLeap(int year) {
        return ((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0;
    }

    public static void task1() {
        int year = 2022;
        if(isLeap(year))
            System.out.println(year + " год является високосным");
        else System.out.println(year + " год не является високосным");
    }

    public static void checkVersion(int OS, int clientDeviceYear) {
        int currentYear = LocalDate.now().getYear();

        if(clientDeviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для " + (OS == 0 ? "iOS" : "Android") + " по ссылке");
        } else System.out.println("Установите версию приложения для " + (OS == 0 ? "iOS" : "Android") + " по ссылке");
    }

    public static void task3() {
        int days = calcDeliveryDays(99);
        System.out.println("Потребуется дней: " + days);
    }

    public static int calcDeliveryDays(int deliveryDistance) {
        int days = 1;
        if(deliveryDistance < 20)
            days = 1;
        else if(deliveryDistance < 60)
            days = 2;
        else if(deliveryDistance < 100)
            days = 3;
        else {
            int extraDistance = deliveryDistance - 19;
            days = 1 + extraDistance / 40;
            if(extraDistance > 0 && (extraDistance % 40) != 0)
                days++;
        }
        return days;
    }

    public static void checkDoubles(String message) {
        for(int i = 0; i < message.length();) {
            char currSym = message.charAt(i++);
            if(i >= message.length())
                break;

            if(currSym == message.charAt(i++)) {
                System.out.println("Присутствую дублирующий символ: " + currSym);
                return;
            }
        }
        System.out.println("Символы строки уникальны");
    }

    public static void task5() {
        int[] arr = new int[] {3, 2, 1, 6, 5};
        System.out.println("Входящий массив: " + Arrays.toString(arr));

        reverseArray(arr);

        System.out.println("Результирующий массив: " + Arrays.toString(arr));
    }

    public static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            final int index = arr.length - 1 - i;
            final int tmp = arr[index];
            arr[index] = arr[i];
            arr[i] = tmp;
        }
    }
}

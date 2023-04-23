package lesson1;
import java.util.Calendar;
import java.util.Arrays;

//1. Написать метод, принимающий на вход два аргумента: len и initialValue,
// и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;

//2. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

//3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами
// (можно только одну из диагоналей, если обе сложно).
// Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
// то есть [0][0], [1][1], [2][2], …, [n][n];

//4. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//"Доброе утро, <Имя>!", если время от 05:00 до 11:59
//"Добрый день, <Имя>!", если время от 12:00 до 17:59;
//"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//"Доброй ночи, <Имя>!", если время от 23:00 до 4:59

//5.** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
// или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
// Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
// Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ];
// [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг
// можете выбирать сами.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = task1();
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.print("\n");
        task2();
        task3();
        task4();
        int[] nums = new int[]{3, 2, 1, 5};
        task5(nums, -2);
    }

    private static int[] task1() {
        System.out.println("task 1");
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите len:");
        int len = Integer.parseInt(myScanner.nextLine());
        System.out.printf("len = %s\n", len);

        System.out.println("Введите initialValue:");
        int initialValue = Integer.parseInt(myScanner.nextLine());
        System.out.printf("initialValue = %s\n", initialValue);

        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = initialValue;
        }
        return arr;
    }

    private static void task2() {
        System.out.println("task 2");
        int[] nums = new int[]{3, 2, 1, 5};
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }
        System.out.print("max = " + max + " ");
        System.out.print("min= " + min + " ");
        System.out.print("\n");
    }

    private static void task3() {
        System.out.println("task 3");
        int [][] twoDimArray = {{5,7,3,17}, {7,0,1,12}, {8,1,2,3}, {1,2,3,4}};
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0, x = twoDimArray[i].length - 1; j < twoDimArray[i].length; j++, x--) {
                if (i == j || i == x) twoDimArray[i][j] = 1;
                System.out.print(twoDimArray[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private static void task4() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Введите имя:");
        String name = myScanner.nextLine();
        Calendar now = Calendar.getInstance();
        int current_time_hour = now.get(Calendar.HOUR_OF_DAY);
        int current_time_minute = now.get(Calendar.MINUTE);
        System.out.println(now.get(Calendar.HOUR_OF_DAY)
                + ":"
                + now.get(Calendar.MINUTE));
        if (current_time_hour > 5 && 11 > current_time_hour && current_time_minute > 0 && current_time_minute < 59){
            System.out.printf("Доброе утро, %s", name);
        }
        if (current_time_hour > 12 && 17 > current_time_hour && current_time_minute > 0 && current_time_minute < 59){
            System.out.printf("Добрый день, %s", name);
        }
        if (current_time_hour > 18 && 22 > current_time_hour && current_time_minute > 0 && current_time_minute < 59){
            System.out.printf("Добрый вечер, %s", name);
        }
        if (current_time_hour > 0 && 4 > current_time_hour && current_time_minute > 0 && current_time_minute < 59){
            System.out.printf("Доброй ночи, %s", name);
        }
    }

    private static void task5(int[] arr, int n) {
        int size = arr.length;

        if (n > 0) {
            n = n % size;
            int rightShiftedArray[] = new int[size];
            for (int i = 0; i < size; i++) {
                rightShiftedArray[(n + i) % size] = arr[i];
            }
            System.out.println("right shifted array");
            for (int ele : rightShiftedArray)
                System.out.println(ele);
        }
        if (n < 0) {
            n = Math.abs(n);
            int[] leftShiftedArray = new int[size];
            for (int i = 0; i < size; i++) {
                int pos = i - n;
                if (pos >= 0)
                    leftShiftedArray[pos] = arr[i];
                else
                    leftShiftedArray[pos + size] = arr[i];
            }
            System.out.println("left shifted array");
            for (int ele : leftShiftedArray)
                System.out.println(ele);
        }
    }
}

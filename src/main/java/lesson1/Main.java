package lesson1;

//1. Написать метод, принимающий на вход два аргумента: len и initialValue,
// и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;

//2. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;

//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами
// (можно только одну из диагоналей, если обе сложно).
// Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
// то есть [0][0], [1][1], [2][2], …, [n][n];

//5. В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
//"Доброе утро, <Имя>!", если время от 05:00 до 11:59
//"Добрый день, <Имя>!", если время от 12:00 до 17:59;
//"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//"Доброй ночи, <Имя>!", если время от 23:00 до 4:59

//6.** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = task1();
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.print("\n");
        task2();
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
        System.out.print(max + " ");
        System.out.print(min + " ");
    }
}

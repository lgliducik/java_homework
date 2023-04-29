package lesson4;


//1. Реализовать консольное приложение, которое:
//Принимает от пользователя и “запоминает” строки.
//Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//Если введено revert, удаляет предыдущую введенную строку из памяти.
//
//2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        ex1();
        ex2();
    }
    private static void ex1() {

        Scanner myScanner = new Scanner(System.in);
        System.out.println("В каком порядке отображать список:");
        String str = myScanner.nextLine();
        List<String> mass = new LinkedList<>();

        int stop = 0;
        while (stop == 0) {
            System.out.println("Введите строку или exit:");
            String str_line = myScanner.nextLine();
            if (!str_line.equals("exit")) {
                mass.add(str_line);
            }
            else{
                stop = 1;
            }
        }
        mass.sort(Comparator.reverseOrder());
        if (str.equals("print")){
            System.out.println("Size = "+ mass.size());
            for (int i = 0; i < mass.size(); i++)
                System.out.println(mass.get(i));
        }
        if (str.equals("revert")){
            System.out.println("remove = "+ mass.get(0));
            mass.remove(0);

            for (int i = 0; i < mass.size(); i++)
                System.out.println(mass.get(i));
        }
    }

    private static void ex2() {
        List<Integer> mass = new LinkedList<>(Arrays.asList(1,2,3,4,5));

        System.out.println("input list");
        for (int i = 0; i < mass.size(); i++)
            System.out.println(mass.get(i));

        System.out.println("reverted list");
        for (int i = mass.size()-1; i >= 0; i--)
            System.out.println(mass.get(i));
    }
}

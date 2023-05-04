package lesson5;


//1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
// что 1 человек может иметь несколько телефонов.
//2. Пусть дан список сотрудников:
//Иван Иванов
//Светлана Петрова
//Кристина Белова
//Анна Мусина
//Анна Крутова
//Иван Юрин
//Петр Лыков
//Павел Чернов
//Петр Чернышов
//Мария Федорова
//Марина Светлова
//Мария Савина
//Мария Рыкова
//Марина Лугова
//Анна Владимирова
//Иван Мечников
//Петр Петин
//Иван Ежов
//Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

import java.util.Arrays;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
    }
    private static void ex1() {
        HashMap<String, ArrayList<String>> phoneNumber = new HashMap<>();
        ArrayList<String> phones = new ArrayList<>(Arrays.asList("+7911111111", "+7911111112", "+7911111113"));
        phoneNumber.put("Иван Иванов", phones);

        ArrayList<String> phones_petr = new ArrayList<>();
        phones_petr.add("+7911111114");
        phones_petr.add("+7911111116");
        phoneNumber.put("Петр Иванов", phones_petr);
    }

    private static void ex2() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Иван Иванов");
        names.add("Светлана Петрова");
        names.add("Кристина Белова");
        names.add("Анна Мусина");
        names.add("Анна Крутова");
        names.add("Иван Юрин");
        names.add("Петр Лыков");
        names.add("Павел Чернов");
        names.add("Петр Чернышов");
        names.add("Мария Федорова");
        names.add("Марина Светлова");
        names.add("Мария Рыкова");
        names.add("Марина Лугова");
        names.add("Анна Владимирова");
        names.add("Иван Мечников");
        names.add("Петр Петин");
        names.add("Иван Ежов");

        HashMap<String, Integer> name_counter = new HashMap<String, Integer>();

        for (String value : names) {
            String name = value.split(" ")[0];
            boolean isKeyExists = name_counter.containsKey(name);
            int count = 1;
            if (isKeyExists) {
                count = name_counter.get(name);
                count++;
                name_counter.put(name, count);
            } else {
                name_counter.put(name, count);
            }
        }

        List<Map.Entry<String,Integer>> entryList = new ArrayList<>(name_counter.entrySet());

        Comparator<Map.Entry<String,Integer>> entryComparator = Comparator.comparingInt(Map.Entry::getValue);

        entryList.sort(entryComparator.reversed());
        for (Map.Entry<String,Integer> s : entryList) {
            System.out.println(s);
        }
    }
}

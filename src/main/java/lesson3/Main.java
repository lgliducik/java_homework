package lesson3;


//1. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа.
// Пройти по списку, найти и удалить целые числа.
//Пример: {"Яблоко", "11", "13", "Апельсин", "Дыня", "17"} -> {"Яблоко", "Апельсин", "Дыня"}

//2. Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
// что на 0й позиции каждого внутреннего списка содержится название жанра,
// а на остальных позициях - названия книг. Напишите метод для заполнения данной структуры(можно через консоль).
//Пример:
//"Классика", "Преступление и наказание", "Война и мир", "Анна Каренина".
//"Научная фантастика", "Солярис", "Ночной дозор", "Братья Стругацкие".
//"Детектив", "Десять негритят".
//"Фантастика", "Хроники Нарнии", "Гарри Поттер и философский камень", "Грозовой перевал".

//3. Доделать задание 2.2 участникам семинара


import java.util.*;

public class Main {

    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
    }
    private static void ex1() {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("Яблоко", "11", "14","15", "Апельсин", "Дыня", "17"));
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++){
            try {
                Integer.parseInt(arr.get(i));
            }
            catch (NumberFormatException e) {
                result.add(arr.get(i));
            }
        }
        System.out.println(result);
    }
    private static void ex2() {
        List<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();

        ArrayList<String> genre1 = new ArrayList<String>();
        genre1.add("Классика");
        genre1.add("Преступление и наказание");
        arr.add(genre1);

        ArrayList<String> genre2 = new ArrayList<String>();
        genre2.add("Научная фантастика");
        arr.add(genre2);

        ArrayList<String> genre3 = new ArrayList<String>();
        genre3.add("Детектив");
        arr.add(genre3);

        ArrayList<String> genre4 = new ArrayList<String>();
        genre4.add("Фантастика");
        arr.add(genre4);

        int stop = 0;
        while (stop == 0) {
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Введите жанр (1-Классика, 2-Научная фантастика, 3-Детектив, 4-Фантастика) или 5-выход:");
            int genre = Integer.parseInt(myScanner.nextLine());
            String bookName = new String();
            if (genre!=5) {
                System.out.println("\nВведите название книги: ");
                bookName = myScanner.nextLine();
            }
            switch (genre) {
                case (1):
                    genre1.add(bookName);
                    break;
                case (2):
                    genre2.add(bookName);
                    break;
                case (3):
                    genre3.add(bookName);
                    break;
                case (4):
                    genre4.add(bookName);
                    break;
                case (5):
                    stop = 1;
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Нет такого жанра");
                    break;
            }
        }
        System.out.println("Size = "+ arr.size());
        for (int i = 0; i < arr.size(); i++)
            System.out.println(arr.get(i));
    }

    private static void ex3() {
        String[] planetsNamesStringArray = {"Mercury", "Jupiter", "Venus", "Earth", "Mars", "Saturn", "Neptune", "Pluto", "Uranus"};
        List<String> randomSolarSystem = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++){
            randomSolarSystem.add(planetsNamesStringArray[random.nextInt(planetsNamesStringArray.length)]);
        }
        System.out.println("input: " + randomSolarSystem);
        List<String> randomSolarSystemUnique = new ArrayList<>();
        randomSolarSystemUnique.add(randomSolarSystem.get(0));
        for (int i = 0; i < randomSolarSystem.size(); i++){
            if (!randomSolarSystemUnique.contains(randomSolarSystem.get(i))){
                randomSolarSystemUnique.add(randomSolarSystem.get(i));
            }
        }
        System.out.println("output: " + randomSolarSystemUnique);
    }
}

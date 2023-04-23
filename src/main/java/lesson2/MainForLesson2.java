package lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


//1. Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
// используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.
//Пример 1:
//Параметры для фильтрации: {"name:Ivanov", "country:Russia", "city:Moscow", "age:null"}
//Результат: SELECT * FROM USER WHERE name = 'Ivanov' and country = 'Russia' and city = 'Moscow';
//
//Пример 2:
//Параметры для фильтрации: {"name:null", "country:null", "city:null", "age:null"}
//Результат: SELECT * FROM USER;
//.
//
//2.Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида:
//1 Расширение файла: txt
//2 Расширение файла: pdf
//3 Расширение файла:
//4 Расширение файла: jpg

public class MainForLesson2 {

    public static void main(String[] args) {
        ex1("{\"name:Ivanov\", \"country:Russia\", \"city:Moscow\", \"age:null\"}");
        ex1("{\"name:null\", \"country:null\", \"city:null\", \"age:null\"}");
        ex2();
    }
    private static void ex2() {
        String pathProject = System.getProperty("user.dir");
        System.out.printf("pathProject = %s\n", pathProject);
        File file = new File(pathProject);
        if (!(file.isDirectory() || file.exists())){
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String filename: file.list()){
            String extension = "";
            int i = filename.lastIndexOf('.');
            if (i > 0) {
                extension = filename.substring(i+1);
                sb.append(filename).append("\tРасширение файла:" + extension).append(System.lineSeparator());
            }
        }
        System.out.println(sb);
        try (PrintWriter pw = new PrintWriter("src/files/filetest.txt")){
            pw.print(sb);
        }
        catch (FileNotFoundException e){
            throw new RuntimeException();
        }
    }

    private static void ex1(String json) {
        String str = "select * from students where ";
        String str_raw = json.substring(1, json.length() - 1);
        StringBuilder result = new StringBuilder();;
        result.append(str);

        String[] pairs = str_raw.split(",");
        int count = 0;
        for (String pair: pairs) {
            int size = pair.length();
            String raw_pair = pair.replace("\"", "");

            String[] key_values = raw_pair.split(":");
            if (!key_values[1].equals("null")) {
                String[] key_values_new = {key_values[0], "'" + key_values[1] + "'"};
                for (String key_value : key_values_new) {
                    result.append(key_value);
                    result.append(" = ");
                }
                result.delete(result.length()-3, result.length());
                result.append(" and ");
                count++;
            }
        }
        if (count > 0) {
            result.delete(result.length() - 5, result.length());
        }
        else {
            result.delete(result.length() - 7, result.length());
        }
        result.append(";");
        System.out.printf("result = %s\n", result);
    }
}

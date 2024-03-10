// Напишите приложение, которое будет запрашивать у пользователя следующие данные,
// разделенные пробелом:
//
// Фамилия Имя Отчество дата _ рождения номер _ телефона пол
//
// Форматы данных:
// фамилия, имя, отчество - строки
// дата _ рождения - строка формата dd.mm.yyyy
// номер _ телефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.
//
// Приложение должно проверить введенные данные по количеству. Если количество не совпадает,
// вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше или
// больше данных, чем требуется.
//
// Приложение должно распарсить полученную строку и выделить из них требуемые значения. Если
// форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно
// использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
// пользователю выведено сообщение с информацией, что именно неверно.
//
// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него
// в одну строку должны записаться полученные данные, вида
//        <Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>
//
// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// Не забудьте закрыть соединение с файлом.
// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно
// обработано, пользователь должен увидеть стектрейс ошибки.

package s3_taskFinalHW;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class TaskFinalHW {
    public static void main(String[] args) throws IOException {
        List<Object> ls = new ArrayList<>();

        if (args.length == 0) {
            // Инициализация ввода с консоли
            Scanner console = new Scanner(System.in);

            System.out.println("Введите черз пробел:");
            System.out.println("Фамилию Имя Отчество дату_рождения(dd.mm.yyyy) номер_телефона пол(символ латиницей f или m)\n");

            // Получение с консоли строки и разбитие её на массив строк по пробелам
            args = console.nextLine().split(" ");
        }

        // Проверка введенных данных по количеству
        try {
            if (args.length > 6 | args.length < 6)
                throw new IllegalArgumentException();
        }
        catch (IllegalArgumentException e){
            if (args.length > 6)
                System.out.println("Ошибка! Вы ввели больше данных чем нужно!");
            else
                System.out.println("Ошибка! Вы ввели меньше данных чем нужно!");
            return;
        }

        // Заполнение ls массивом строк
        Collections.addAll(ls, args);

        // Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.

        // Преобразование строки в дату
        try {
            String[] str = ls.get(3).toString().split("\\.");
            if (!(str.length == 3))
                throw new IndexOutOfBoundsException();
            Calendar calendar = new GregorianCalendar(parseInt(str[2]), parseInt(str[1]), parseInt(str[0]));
            ls.remove(3);
            ls.add(3, calendar);
        }catch (NumberFormatException e){
            System.out.println("Ошибка! Неверное распознавание даты рождения.");
            return;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Ошибка! Дата рождения состоит не из трёх цифр.");
            return;
        }

        // Преобразование строки в номер телефона
        try{
            String nPhone = ls.get(4).toString();
            ls.remove(4);
            ls.add(4, parseLong(nPhone));
        }catch (NumberFormatException e){
            System.out.println("Ошибка! Неверное распознавание номера телефона.");
            return;
        }

        // Проверка пола
        if ( !(Objects.equals(ls.get(5).toString(), "f") | Objects.equals(ls.get(5).toString(), "m"))){
            throw new MyException();
        }

        // Построение строки
        StringBuilder sBuilder = new StringBuilder();
        for (Object value : ls){
            if (value instanceof Calendar) {
                sBuilder.append(((Calendar) value).get(5)).append(".");
                sBuilder.append(((Calendar) value).get(2)).append(".");
                sBuilder.append(((Calendar) value).get(1)).append(" ");
            }
            else
                sBuilder.append(value.toString()).append(" ");
        }

        System.out.println(String.valueOf(sBuilder));


        // Запись результата в файл
        try{
            String filename = ls.get(0).toString() + ".txt";
            // Проверка - существует ли файл?
            File file1 = new File(filename);
            boolean success = file1.isFile();
            // Создаём/открываем файл с параметром добавления строк
            FileWriter fw = new FileWriter(filename, true);
            // Если файл существует добавляем в файл пеервод строки
            // и добавляем новую строку
            if(success){
                fw.write("\n");
            }
            fw.write(String.valueOf(sBuilder));
            fw.flush();
            fw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}


class MyException extends RuntimeException{
    public MyException(){
        super("ошибка! Пол задан не значениями m или f ");
    }
}
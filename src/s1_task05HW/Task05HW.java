//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения.
//
//Метод arrayOutOfBoundsException - Ошибка, связанная с выходом за пределы массива
//Метод divisionByZero - Деление на 0
//Метод numberFormatException - Ошибка преобразования строки в число
//
//Важно: они не должны принимать никаких аргументов

package s1_task05HW;

class Answer {
    public static void arrayOutOfBoundsException() {
        // Напишите свое решение ниже
        int[] array = {1,2,3,};
        int a = array[5];

    }

    public static void divisionByZero() {
        // Напишите свое решение ниже
        int b=7, c=0, d;
        d= b /c;

    }

    public static void numberFormatException() {
        // Напишите свое решение ниже
        int e = Integer.parseInt("1498O");

    }
}

public class Task05HW {
    public static void main(String[] args) {
        Answer ans = new Answer();
        try {
            ans.arrayOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива");
        }

        try {
            ans.divisionByZero();
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль");
        }

        try {
            ans.numberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования строки в число");
        }
    }
}
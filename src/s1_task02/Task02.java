// Задание №2
// Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
// Необходимо посчитать и вернуть сумму элементов этого массива.
// При этом накладываем на метод 2 ограничения: метод может работать только с
// квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать
// только значение 0 или 1.
// Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об
// ошибке.

package s1_task02;

public class Task02 {
    public static void main(String[] args) {
        int[][] array0 = {{1, 0}, {1, 1} };
        checkMatrix(array0);

    }

    public static void checkMatrix(int[][] array){
        int sum = 0;
        if (array == null) throw new RuntimeException("Массив пустой");
        if (array.length != array[0].length) throw new RuntimeException("Размеры массива не совпадают");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1) throw new RuntimeException("Число в массиве не 1 или 0 ");
                sum+=array[i][j];
            }
        }
        System.out.println(sum);
    }


}

//       1. Напишите метод, на вход которого подаётся двумерный строковый массив
//размером 4х4. При подаче массива другого размера необходимо бросить
//исключение MyArraySizeException.
//        2. Далее метод должен пройтись по всем элементам массива, преобразовать в
//int и просуммировать. Если в каком-то элементе массива преобразование
//не удалось (например, в ячейке лежит символ или текст вместо числа),
//должно быть брошено исключение MyArrayDataException с детализацией, в
//какой именно ячейке лежат неверные данные.
//        3. В методе main() вызвать полученный метод, обработать возможные
//исключения MyArraySizeException и MyArrayDataException и вывести
//результатрасчета (сумму элементов,при условии что подали на вход
//корректный массив).

package s3_task16;

public class Task16 {
    public static void main(String[] args) {

    }

    public static int sumElementsArray(String[][] array){
        if(array.length != 4 && array[0].length != 4)
            throw new MyArraySizeException(array.length, array[0].length);
        int resultSum = 0;
        for(int i = 0; i < array.length; i++){
            for(int j =0; j < array[i].length; j++){
                try {
                    resultSum += Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return resultSum;
    }
}

class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(int rows, int columns){
        super("Массив должен иметь размер 4х4, у вас (" + rows + ", " + columns + ")");
    }
    public MyArraySizeException(){
        super("Массив должен иметь размер 4х4");
    }
}
class MyArrayDataException extends NumberFormatException{
    public MyArrayDataException(int i, int j){
        super("не удалось преобразовать элемент находящийся на позиции (" + i + ", " + j + ")");
    }
    public MyArrayDataException(){
        super("не удалось преобразовать элемент");
    }
}
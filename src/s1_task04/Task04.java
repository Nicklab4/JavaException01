package s1_task04;

public class Task04 {
    public static void main(String[] args) {
        int[] array0 = {1,2,3};
        int[] array1 = {4,5,6};
        for(int i : sumElementsArray(array0, array1))
            System.out.print(i + " ");
        int[] array2 = {1,2};
        int[] array3 = {4,5,6};
        for(int i : sumElementsArray(array2, array3))
            System.out.print(i + " ");

    }

    public static int[] sumElementsArray(int[] arrayFirst, int[] arraySecond){
        if (arrayFirst.length != arraySecond.length)
            throw new RuntimeException("Длинны массивов не равны");
        int[] resultArray = new int[arrayFirst.length];
        for (int i = 0; i < arrayFirst.length; i++) {
            resultArray[i] = arrayFirst[i] + arraySecond[i];
        }
        return resultArray;
    }
}

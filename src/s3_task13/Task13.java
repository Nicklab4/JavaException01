package s3_task13;

import java.io.IOException;

public class Task13 {
    public static void main(String[] args) {
        try {
            doSomething();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void doSomething() throws IOException{
        throw new IOException("Какое-то исключение");
    }
}

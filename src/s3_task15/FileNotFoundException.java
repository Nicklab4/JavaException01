package s3_task15;

public class FileNotFoundException extends java.io.FileNotFoundException {
    public FileNotFoundException(){
        super("Файл не найден");
    }

    public FileNotFoundException(String path){
        super("Файл по пути " + path + " не найден.");
    }
}
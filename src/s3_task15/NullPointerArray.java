package s3_task15;

public class NullPointerArray extends NullPointerException{
    public NullPointerArray() {
        super("Элемент пустой");
    }
    public NullPointerArray(int count){
        super("Элемент на этом индексе " + count + " пустой");
    }

}

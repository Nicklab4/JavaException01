package s3_task14;

import java.io.IOException;

public class Task14 {
    private Integer count;

    public static void main(String[] args) throws IOException {
        Task14 task14 = new Task14();
        task14.add();
        task14.add();
        task14.add();
        System.out.println(task14.getCount());
        task14.closeTerminate();
        task14.add();
        System.out.println(task14.getCount());

    }

    public Task14() {
        this.count = 0;
    }

    public void add() throws IOException{
        checked();
        this.count++;
    }

    public void checked() throws IOException{
        if (this.count == null){
            throw  new IOException("Невозможно сложить");
        }
    }

    public int getCount() throws IOException{
        checked();
        return this.count;
    }

    public void closeTerminate(){
        this.count = 0;
    }
}

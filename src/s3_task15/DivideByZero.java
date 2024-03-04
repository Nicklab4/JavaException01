package s3_task15;

public class DivideByZero extends ArithmeticException {
    public DivideByZero(){
        super("Нельзя делить на ноль");
    }
}

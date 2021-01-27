package calculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String value = Double.toString(calculator.getAnswer("1 + 2"));
        System.out.println(value);
    }
}

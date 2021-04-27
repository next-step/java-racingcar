package study;

public class calApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String[] splitInput = {};
        int result = 0;

        String input = calculator.input();

        result = calculator.makeResult(input);
        System.out.println(result);
    }
}

package step2;

public class Main {
    public static void main(String[] args) {
        UserInput input = new UserInput();
        Calculator calculator = new Calculator();

        System.out.println(calculator.stringCalculatingProcessor(input.getUserInput()));
    }
}

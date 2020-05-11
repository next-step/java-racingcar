package step2.calculator;

public class Calculator {

    public void run(String input) {
        checkInputValidation(input);
        String[] arr = input.split(" ");
    }

    private void checkInputValidation(String input) {
        if (input == null)
            throw new IllegalArgumentException();
        if (input.trim().equals(""))
            throw new IllegalArgumentException();
    }
}

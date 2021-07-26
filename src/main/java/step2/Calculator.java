package step2;

public class Calculator {

    private static boolean checkInputValid(String input) {
        return input != null && !input.equals("");
    }

    public static long calculate(String input){
        if (checkInputValid(input))
            throw new IllegalArgumentException();

        return 0;
    }
}

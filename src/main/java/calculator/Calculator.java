package calculator;

public class Calculator {



    public int sum(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        StringSpliter stringSpliter = new StringSpliter();
        String[] split = stringSpliter.split(input);
        return sum(toPositives(split));
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty() || input.isBlank();
    }

    private int sum(Positives positives) {
        return positives.sum();
    }

    private Positives toPositives(String[] input) {
        return new Positives(input);
    }
}

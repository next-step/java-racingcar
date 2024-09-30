package calculator;

public class Calculator {

    public int sum(String input) {
        if (isEmpty(input)) {
            return 0;
        }
        Source source = new Source();
        String[] split = source.split(input);
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

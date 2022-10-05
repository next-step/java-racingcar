package calculator;

public enum Calculator {
    SIMPLE_CALCULATOR(new SimpleCalculator()),
    CUSTOMIZED_CALCULATOR(new CustomizedCalculator());

    private final Calculatable calculatable;

    Calculator(Calculatable calculatable) {
        this.calculatable = calculatable;
    }
    public static int sum(String input) throws IllegalArgumentException {
        if (hasNoInput(input)) {
            return 0;
        }

        if (isCustomizedInput(input)) {
            return calculate(CUSTOMIZED_CALCULATOR.calculatable, input);
        }

        return calculate(SIMPLE_CALCULATOR.calculatable, input);
    }

    private static boolean hasNoInput(String input) {
        return input == null || input.isBlank();
    }

    private static boolean isCustomizedInput(String input) {
        return input.matches("//(.)+\\\\n+(.*)");
    }

    private static int calculate(Calculatable calculatable, String input) {
        calculatable.validateInput(input);
        return calculatable.parseInput(input).stream().mapToInt(e -> e).sum();
    }
}

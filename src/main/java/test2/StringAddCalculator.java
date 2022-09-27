package test2;

public class StringAddCalculator {

    public static final String SEPARATOR = "//|\\.|\n|,|:|;";

    public static Positive splitAndSum(String text) {
        if(isBlank(text)) {
            return new Positive(0);
        }
        return sum(toPositives(split(text)));
    }

    private static String[] split(String text) {
        return text.split(SEPARATOR, -1);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static Positive sum(Positive[] numbers) {
        Positive result = new Positive(0);

        for(Positive number : numbers) {
            result = result.plus(number);
        }
        return result;
    }

    private static Positive[] toPositives(String[] values) {
        Positive[] numbers = new Positive[values.length];
        for(int i = 0; i < values.length; i ++) {
            numbers[i] = isNotNull(values[i]);
        }
        return numbers;
    }

    private static Positive isNotNull(String value) {
        if(value.isBlank() || value.isEmpty()) {
           return new Positive(0);
        }
        return new Positive(value);
    }

}

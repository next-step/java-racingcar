package calculator;

public class StringCalculator {
    public double calculate(final String s) throws IllegalArgumentException {
        if (s == null) {
            throw new IllegalArgumentException("");
        }

        String[] elements = s.split(" ");
        if (elements.length % 2 != 1) {
            throw new IllegalArgumentException("");
        }

        double result = Converter.toDouble(elements[0]);
        for (int i = 1; i < elements.length; i += 2) {
            String op = elements[i];
            double num = Converter.toDouble(elements[i + 1]);
            result = Operator.calculate(op, result, num);
        }
        return result;
    }

}

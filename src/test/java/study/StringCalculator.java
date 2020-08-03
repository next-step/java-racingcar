package study;

public class StringCalculator {
    private final String input;

    public StringCalculator(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 값이거나 빈 공백 문자열입니다.");
        }
        this.input = input;
    }

    public int calculate() {
        String[] seperatedValue = input.split(" ");
        int num = Integer.parseInt(seperatedValue[0]);

        for (int i = 1; i < seperatedValue.length; i = i + 2) {
            Operator operation = Operator.findOperation(seperatedValue[i]);
            num = operation.compute(num, Integer.parseInt(seperatedValue[i + 1]));
        }
        return num;
    }
}

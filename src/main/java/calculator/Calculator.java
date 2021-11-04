package calculator;

public class Calculator {

    public int calculate(String input) {
        String[] split = input.split(" ");

        CalNumber first = new CalNumber(split[0]);
        String operation = split[1];
        CalNumber second = new CalNumber(split[2]);

        CalNumber result = first.calculate(second, operation);

        for (int i = 3; i < split.length; i += 2) {

            isValidLength(split, i);
            CalNumber to = new CalNumber(split[i + 1]);
            operation = split[i];

            result = result.calculate(to, operation);
        }

        return result.getNumber();
    }

    private void isValidLength(String[] split, int i) {
        if (split.length <= i + 1) {
            throw new IllegalArgumentException("input 규격이 맞지 않습니다.");
        }
    }

}

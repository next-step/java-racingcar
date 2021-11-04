package calculator;

public class Calculator {

    public int calculate(String input) {
        String[] split = input.split(" ");

        CalNumber first = new CalNumber(split[0]);
        String operation = split[1];
        CalNumber second = new CalNumber(split[2]);

        CalNumber result = calculate(first, operation, second);

        for (int i = 3; i < split.length; i += 2) {

            isValidLength(split, i);

            first = result;
            operation = split[i];

            second = new CalNumber(split[i + 1]);

            result = calculate(first, operation, second);
        }

        return result.getNumber();
    }

    private void isValidLength(String[] split, int i) {
        if (split.length <= i + 1) {
            throw new IllegalArgumentException("input 규격이 맞지 않습니다.");
        }
    }

    private CalNumber calculate(CalNumber first, String operation, CalNumber second) {
        if (operation.equals("+")) {
            return first.plusBy(second);
        }

        if (operation.equals("-")) {
            return first.minusBy(second);
        }

        if (operation.equals("*")) {
            return first.multipleBy(second);
        }

        if (operation.equals("/")) {
            return first.dividedBy(second);
        }

        throw new IllegalArgumentException("operation이 잘못되었습니다.");
    }


}

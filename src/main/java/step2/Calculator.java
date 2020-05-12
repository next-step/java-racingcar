package step2;

public class Calculator {

    private static final String BLANK = " ";
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    public int calculate(String input){

        nullOrEmptyCheck(input);

        String[] split = input.split(BLANK);

        int result = Integer.parseInt(split[FIRST_INDEX]);

        for (int i = SECOND_INDEX; i < split.length; i++) {
            String operation = split[i];
            String nextValue = null;

            if (isNumber(operation)) {
                continue;
            }

            nextValue = split[i + SECOND_INDEX];
            int nextNum = Integer.parseInt(nextValue);

            Operator operator = Operator.findOperator(operation);

            result = operator.operate(result, nextNum);
        }

        return result;
    }

    private void nullOrEmptyCheck(String input){
        if (input == null || (input.replaceAll(" ", "").isEmpty())) {
            throw new IllegalArgumentException("입력값이 null 이거나 비어있습니다.");
        }
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}

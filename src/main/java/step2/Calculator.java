package step2;

public class Calculator {

    private static final String BLANK = " ";

    public int calculate(String input){

        nullOrEmptyCheck(input);

        String[] split = input.split(BLANK);

        int result = Integer.parseInt(split[0]);

        for (int i = 1; i < split.length; i++) {
            String operation = split[i];
            String nextValue = null;

            if (isNumber(operation)) {
                continue;
            }

            nextValue = split[i + 1];
            int nextNum = Integer.parseInt(nextValue);

            result = Operation.calculate(operation, result, nextNum);
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

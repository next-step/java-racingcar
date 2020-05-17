package calculator;

public class StringCalculator {

    private static final String DELIMITER = " ";
    private static final int LOOP_INITIAL_NUMBER = 1;
    private static final int LOOP_COUNTER = 2;
    private static final int NEXT_NUMBER_OFFSET = 1;

    public int calculate(String input) {
        validateInput(input);

        String[] splitInput = input.split(DELIMITER);

        int answer = Integer.parseInt(splitInput[0]);
        for (int i = LOOP_INITIAL_NUMBER; i < splitInput.length; i += LOOP_COUNTER) {
            int number = Integer.parseInt(splitInput[i + NEXT_NUMBER_OFFSET]);

            Operator operator = Operator.OperatorFactory(splitInput[i]);
            answer = operator.operate(answer, number);
        }

        return answer;
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Parameter `input` must not be empty ");
        }
        if (input.split(DELIMITER).length % 2 == 0) {
            throw new IllegalArgumentException("Result `input.split(DELIMITER).length` must be odd number");
        }
    }
}

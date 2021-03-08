public class Calculator {

    public static final int MINIMUN_SIZE = 2;


    public Integer progress(String numbersAndOperators) {
        String[] strings = getSplitString(numbersAndOperators);
        Integer result = getNumber(strings[0]);
        int arrayLength = strings.length;

        for (int i = 1; i < arrayLength; i+=2) {
            arrayIndexValidation(arrayLength, i);
            Integer number = getNumber(strings[i + 1]);
            String operator = strings[i];
          
            result = Operation.of(operator).getResult(result , number);
        }
        return result;
    }

    private void arrayIndexValidation(int arraySize, int index) {
        if (arraySize <= index + 1) {
            throw new IllegalArgumentException(Message.EMPTY_NUMBER);
        }
    }

    private String[] getSplitString(String numberAndOperator) {
        if (numberAndOperator == null || numberAndOperator.length() < MINIMUN_SIZE) {
            throw new IllegalArgumentException(Message.INVALID_ARGUMENT);
        }
        return numberAndOperator.split(" ");
    }

    private Integer getNumber(String number) {
        if (number.isEmpty()) {
            throw new IllegalArgumentException(Message.EMPTY_NUMBER);
        }
        return Integer.parseInt(number);
    }
}

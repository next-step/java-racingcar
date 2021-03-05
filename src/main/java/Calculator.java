public class Calculator {

    public static final Integer FULL_SIZE = 2;

    public Integer progress(String numbersAndOperators) {
        String[] strings = getSplitString(numbersAndOperators);
        Integer result = getNumber(strings[0]);
        int arrayLength = strings.length;

        for (int i = 1; i < arrayLength; i+=2) {
            arrayIndexValidation(arrayLength, i);
            Integer number = getNumber(strings[i + 1]);
            String operator = strings[i];

            result = Operator.of(operator).getResult(result , number);
        }

        return result;
    }

    private void arrayIndexValidation(int arraySize, int index) {
        if (arraySize <= index + 1) {
            throw new IllegalArgumentException();
        }
    }

    private String[] getSplitString(String numberAndOperator) {
        if (numberAndOperator == null || numberAndOperator.length() < 5){
            throw new IllegalArgumentException();
        }
        return numberAndOperator.split(" ");
    }

    private Integer getNumber(String s) {
        if (s.isEmpty()){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(s);
    }
}

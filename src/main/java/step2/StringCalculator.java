package step2;

public class StringCalculator {

    private static final String INPUT_DELIMITER = " ";
    private static final int INDEX_TO_GET_FIRST_VALUE = 0;
    private static final int INDEX_TO_START_CALCULATE = 1;
    private static final int NUMBER_OF_UNITS_TO_CALCULATE = 2;
    private static final int ADDITIONAL_INDEX_TO_GET_VALUE = 1;

    public int calculate(String data) {
        String[] splitData = data.split(INPUT_DELIMITER);
        int result = Integer.parseInt(splitData[INDEX_TO_GET_FIRST_VALUE]);

        for (int i = INDEX_TO_START_CALCULATE; i < splitData.length; i += NUMBER_OF_UNITS_TO_CALCULATE) {
            result = calculateByOperation(result, splitData[i], Integer.parseInt(splitData[i + ADDITIONAL_INDEX_TO_GET_VALUE]));
        }

        return result;
    }

    private int calculateByOperation(int result, String operation, int value) {
        return Operator.getOperatorByCode(operation).calculate(result, value);
    }

}

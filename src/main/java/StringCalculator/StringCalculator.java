package StringCalculator;

public class StringCalculator {
    final private static int FIRST_NUMBER_INDEX = 0;
    final private static int FIRST_OPERATOR_INDEX = 1;
    final private static int NUMBER_INTERVAL = 2;

    public static Double stringParseToDouble(final String strNumber) {
        double number;
        try {
            number = Double.parseDouble(strNumber);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException();
        }
        return number;
    }

    public static Double calculator(final String inputStr) {
        final String[] strArray = new InputString(inputStr).getStringList();
        final int arrayLength = strArray.length;
        double result = stringParseToDouble(strArray[FIRST_NUMBER_INDEX]);

        for (int i = FIRST_OPERATOR_INDEX; i < arrayLength; i += NUMBER_INTERVAL) {
            result = CalculatorType.getCalculatorWithSymbol(strArray[i])
                    .calculate(result, stringParseToDouble(strArray[i + 1]));
        }

        return result;
    }

}

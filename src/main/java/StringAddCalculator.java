public class StringAddCalculator {

    public static int splitAndSum(String value) {
        NumberOperator numberOperator = new NumberOperator();
        StringOperator stringOperator = new StringOperator(value);

        if (stringOperator.isNotBlank(stringOperator)) {
            String[] numberArr = stringOperator.split();

            numberOperator.parseIntList(numberArr).forEach(numberOperator::sum);
        }

        return numberOperator.getValue();
    }
}

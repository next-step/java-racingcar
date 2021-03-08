package calculator;

public class TddCalculator {

    private Operand operand = new Operand();

    public int calculation(String input) throws Exception {
        String[] strArr = operand.stringToSplitStrArray(input);

        int result = operand.stringToInt(strArr[0]);

        for (int i = 1; i < strArr.length; i+=2) {
            result = OperatorType.findOper(strArr[i])
                    .operation(result, operand.stringToInt(strArr[i+1]));
        }

        return result;
    }
}

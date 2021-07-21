package step2;

public class StringCalculator {
    private final StringParser stringParser;

    public StringCalculator(String text) {
        this.stringParser = new StringParser(text);
    }

    public int calculate() {
        final String[] operatorsAndOperands = stringParser.parse();

        int result = 0;

        for (int i = 0; i < operatorsAndOperands.length; i += 2) {
            final int value = Integer.parseInt(operatorsAndOperands[i]);
            if (i == 0) {
                result += value;
                continue;
            }

            final Operator operator = Operator.of(operatorsAndOperands[i - 1]);
            result = operator.getOperate()
                    .applyAsInt(result, value);
        }

        return result;
    }

}

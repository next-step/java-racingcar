package step2;

public class StringCalculator {
    public static final int INITIAL_INDEX = 0;
    public static final int INCREMENT_INDEX = 2;
    private final StringParser stringParser;

    public StringCalculator(String text) {
        this.stringParser = new StringParser(text);
    }

    public int calculate() {
        final String[] operatorsAndOperands = stringParser.parse();

        int result = 0;

        final int size = operatorsAndOperands.length;
        for (int i = INITIAL_INDEX; i < size; i += INCREMENT_INDEX) {
            final int value = Integer.parseInt(operatorsAndOperands[i]);
            if (i == INITIAL_INDEX) {
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

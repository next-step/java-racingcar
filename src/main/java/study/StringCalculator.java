package study;

public class StringCalculator {

    private EquationParser parser;

    public StringCalculator(EquationParser parser) {
        this.parser = parser;
    }

    public Operand calculate(String equation) {
        String[] parsed = parser.parse(equation);

        Operand result = Operand.ZERO;
        int firstOperatorIndex = 0;

        if (NumberUtil.isNumeric(parsed[0])) {
            result = new Operand(parsed[0]);
            firstOperatorIndex = 1;
        }

        for (int i = firstOperatorIndex; i < parsed.length; i += 2) {
            Operand operand = new Operand(parsed[i + 1]);
            Operator operator = Operator.findBySymbol(parsed[i]);
            result = operator.calculate(result, operand);
        }

        return result;
    }

}

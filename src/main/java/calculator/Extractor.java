package calculator;

public class Extractor {

    public void addNumber(Number numbers, String[] values, int index) {
        if (index % 2 == 0) {
            numbers.add(values[index]);
        }
    }

    public Number extractNumbers(String[] values) {
        Number numbers = new Number();
        for (int i = 0; i < values.length; i++) {
            addNumber(numbers, values, i);
        }
        return numbers;
    }

    public void addOperator(Operator operators, String[] values, int index) {
        if (index % 2 == 1) {
            operators.add(values[index]);
        }
    }

    public Operator extractOperators(String[] values) {
        Operator operator = new Operator();
        for (int i = 0; i < values.length; i++) {
            addOperator(operator, values, i);
        }
        return operator;
    }
}

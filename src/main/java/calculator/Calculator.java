package calculator;

public class Calculator {
    public Num calculate(String operation) {
        Spliterator spliterator = new Spliterator(operation);

        return calculateAllOperations(spliterator);
    }

    private Num calculateAllOperations(Spliterator spliterator) {
        Num result = spliterator.nextOperand();
        Operator operator;
        Num second;

        do {
            operator = spliterator.nextOperator();
            second = spliterator.nextOperand();
            result = calculateTwoNumbers(result, operator, second);
        } while (spliterator.hasNext());

        return result;
    }

    private Num calculateTwoNumbers(Num first, Operator operator, Num second) {
        return operator.operate(first, second);
    }
}

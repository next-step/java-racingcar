package calculator;

public class Calculator {

    public int calculate(String operation) {
        Spliterator spliterator = new Spliterator(operation);

        return calculateAllOperations(spliterator).getNumber();
    }

    private Num calculateAllOperations(Spliterator spliterator) {
        Object obj = spliterator.next();
        Num first = (Num) obj;
        Operator operator = null;

        do {
            obj = spliterator.next();

            if (obj instanceof Num) {
                first = calculateTwoNumbers(first, operator, (Num) obj);
            }

            if (obj instanceof Operator) {
                operator = (Operator) obj;
            }

        } while (obj != null);

        return first;
    }

    private Num calculateTwoNumbers(Num first, Operator operator, Num second) {
        return operator.operate(first, second);
    }
}

package calculator;

public class Calculator {
    Num result;
    Operator operator = null;

    public int calculate(String operation) {
        Spliterator spliterator = new Spliterator(operation);

        return calculateAllOperations(spliterator).getNumber();
    }

    private Num calculateAllOperations(Spliterator spliterator) {
        Object obj = spliterator.next();
        result = (Num) obj;
        operator = null;

        do {
            obj = spliterator.next();

            checkTypeAndSetValues(obj);

        } while (obj != null);

        return result;
    }

    private void checkTypeAndSetValues(Object obj) {
        if (obj instanceof Num) {
            result = calculateTwoNumbers(result, operator, (Num) obj);
        }

        if (obj instanceof Operator) {
            operator = (Operator) obj;
        }
    }

    private Num calculateTwoNumbers(Num first, Operator operator, Num second) {
        return operator.operate(first, second);
    }
}

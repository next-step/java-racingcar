package step2;

import step2.operation.ArithmeticOperation;
import step2.operation.DivisionOperation;
import step2.operation.MinusOperation;
import step2.operation.MultiplicationOperation;
import step2.operation.PlusOperation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Calculator {
    private final String PLUS = "+";
    private final String MINUS = "-";
    private final String MULTIPLICATION = "*";
    private final String DIVISION = "/";
    private final Map<String, ArithmeticOperation> OPERATION_FUNCTION; // 사칙연산을 담당
    LinkedList<Integer> numbers = new LinkedList<>();
    LinkedList<String> operations = new LinkedList<>();

    public Calculator() {
        OPERATION_FUNCTION = new HashMap<>();
        OPERATION_FUNCTION.put(PLUS, new PlusOperation());
        OPERATION_FUNCTION.put(MINUS, new MinusOperation());
        OPERATION_FUNCTION.put(MULTIPLICATION, new MultiplicationOperation());
        OPERATION_FUNCTION.put(DIVISION, new DivisionOperation());
    }

    public Integer calculate(String target) {
        String[] stringArray = splitStringByBlankValue(target);
        setUpNumbersAndOperations(stringArray);
        calculateNumber();
        return numbers.peek();
    }

    public String[] splitStringByBlankValue(String input) {
        return input.split(" ");
    }

    public void setUpNumbersAndOperations(String[] splittedValue) {
        for (int i = 0; i < splittedValue.length; i++) {
            buildNumbersAndOperationsByIndex(splittedValue[i], numbers, operations, i);
        }
    }

    private void buildNumbersAndOperationsByIndex(String item, LinkedList<Integer> numbers, LinkedList<String> operations, int index) {
        if (index % 2 == 0) {
            addNumber(item, numbers);
            return;
        }
        addOperation(item, operations);
    }

    private void addNumber(String value, LinkedList<Integer> numbers) {
        if (isNumber(value)) {
            numbers.offer(Integer.parseInt(value));
        }
    }

    private void addOperation(String value, LinkedList<String> operations) {
        if (isOperation(value)) {
            operations.offer(value);
        }
    }

    public boolean isNumber(String value) {
        boolean flag = value.matches("^[0-9]*$");
        if (!flag) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
        return true;
    }

    public boolean isOperation(String value) {
        boolean flag = OPERATION_FUNCTION.containsKey(value);
        if (!flag) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다");
        }
        return true;
    }

    public void calculateNumber() {
        // 반복문이 끝나면 사칙연산이 완료된 최종 값이 numbers에 남는다(reduce)
        for (String operation : operations) {
            Integer arg1 = pickNumberArgument();
            Integer arg2 = pickNumberArgument();
            Integer result = OPERATION_FUNCTION.get(operation).apply(arg1, arg2);
            numbers.addFirst(result);
        }
    }

    private Integer pickNumberArgument() {
        return numbers.poll();
    }
}

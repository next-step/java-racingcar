package calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Calculator {


    private int tmpNumber;

    private final Map<String, BiFunction<Integer, Integer, Integer>> operators;


    public Calculator() {
        Map<String, BiFunction<Integer, Integer, Integer>> operators = new HashMap<>();
        operators.put("+", this::add);
        operators.put("-", this::subtract);
        operators.put("*", this::multiply);
        operators.put("/", this::divide);

        this.tmpNumber = 0;
        this.operators = operators;

    }

    public int excute(String strings) {
        String[] stringLst = strings.split(" ");
        Queue<Integer> numbers = numberGroups(stringLst);
        Queue<String> separators = separatorGroups(stringLst);

        return calcute(numbers, separators);
    }

    public Queue<Integer> numberGroups(String[] stringLst) {
        return Arrays.stream(stringLst).filter(StringUtils::isNumeric).map(Integer::parseInt).collect(Collectors.toCollection(LinkedList::new));
    }

    public Queue<String> separatorGroups(String[] stringLst) {
        return Arrays.stream(stringLst).filter(i -> !StringUtils.isNumeric(i)).collect(Collectors.toCollection(LinkedList::new));
    }


    public int calcute(Queue<Integer> numbers, Queue<String> separators) {
        tmpNumber = Objects.requireNonNull(numbers.poll());
        separators.forEach(separator -> process(Objects.requireNonNull(numbers.poll()), separator));

        return tmpNumber;
    }

    private void process(int number, String cal) {
        BiFunction<Integer, Integer, Integer> operator = operators.get(cal);
        if (operator != null) {
            tmpNumber = operator.apply(tmpNumber, number);
        }
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b;
    }
}


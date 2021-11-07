package calculator;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Calculator {
    public static int calculate(String expression) {
        Splitter splitter = new Splitter(expression);
        List<MyNumber> myNumbers = splitter.getMyNumbers();
        List<Operator> operators = splitter.getOperators();
        AtomicInteger operatorIdx = new AtomicInteger(0);

        return myNumbers.stream().reduce((m1, m2) -> operators.get(operatorIdx.getAndIncrement()).operate(m1, m2))
                .orElseThrow(IllegalStateException::new)
                .getNumber();
    }
}

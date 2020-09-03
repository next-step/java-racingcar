package calculator;

import util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Calculator {

    private static List<Operation> operations =  new ArrayList<Operation>();
    static {
        operations.add(new AddOperation());
        operations.add(new SubstractOperation());
        operations.add(new MultipleOperation());
        operations.add(new DivideOperation());
    }
    public static int calculate(String value) {
        String[] values = value.split(" ");
        int result = StringUtil.StringToInt(values[0]);
        for (int i = 1; i < values.length; i+=2) {
            String operator = values[i];
            int second = StringUtil.StringToInt(values[i + 1]);
            result = calculate(result, second, operator);
        }
        return result;
    }

    private static int calculate(int first, int second, String operator) {
        Operator op = Operator.of(operator);
        return op.operate(first, second);

        /*
        //일치하는것 첫번째
        Optional<Operation> maybeOperation = operations.stream().filter(o -> o.isSupport(operator)).findFirst();

        //일치하는것이 없을경우
        Operation operation = maybeOperation.orElseThrow(IllegalArgumentException::new);

        return operation.operate(first, second);
        */
    }

}

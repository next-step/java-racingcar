import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Calculator {

    public static int calculate(ArithmeticArguments args) {

        while (args.hasNextOperator()) {
            Integer[] operands = args.nextOperands();
            Operator operator = args.nextOperator();

            int result = operator.operate(operands[0], operands[1]);

            args.setResult(result);
        }

        return args.getResult();
    }
}

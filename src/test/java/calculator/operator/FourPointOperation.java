package calculator.operator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class FourPointOperation {
    private static final Map<Operation, Operator> operator;
    public enum Operation {
          ADD("+")
        , SUBTRACTION("-")
        , DIVISION("/")
        , MULTIPLICATION("*")
        ;

        private final String operation;
        Operation(String operation) {
            this.operation = operation;
        }

        static Optional<Operation> find(final String strOperation){
            return Stream.of(values())
                         .filter(o->o.operation.equals(strOperation))
                         .findAny()
                ;
        }
    }

    static {
        final Map<Operation, Operator> map = new HashMap();
        map.put(Operation.ADD, (n0, n1)-> n0 + n1);
        map.put(Operation.SUBTRACTION, (n0, n1)-> n0 - n1);
        map.put(Operation.DIVISION, (n0, n1)-> n0 / n1);
        map.put(Operation.MULTIPLICATION, (n0, n1)-> n0 * n1);
        operator = Collections.unmodifiableMap(map);
    }

    public static int compute(int n0, Operation operation, int n1 ){
        return operator.get(operation)
                       .operate(n0, n1)
            ;
    }

    public static Optional<Operation> findOperation(String strOperation){
        return Operation.find(strOperation);
    }
}

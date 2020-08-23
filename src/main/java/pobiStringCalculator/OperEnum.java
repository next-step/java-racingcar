package pobiStringCalculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public enum OperEnum {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLE("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);


    private final String operator;
    private final Op op;

    OperEnum(String operator, Op operation) {
        this.operator = operator;
        this.op = operation;
    }

    public static OperEnum of(String value) {
        Optional<OperEnum> maybeOperEnum = Arrays.stream(values( )).
                filter(o -> o.operator.equals(value)).findFirst();
        return maybeOperEnum.orElseThrow(IllegalArgumentException::new);
    }

    public int operate(int first, int second) {
        return op.operate(first, second);
    }
    //StringCalculator.java의 아래 부분
    //private static int calculate(int first, int second, String operator) {
    ////        //operations.stream() local variable선언 시 Optional<Operation> 자동 반환 : 에러값not Operation고려해 지정
    ////        Optional<Operation> op = operations.stream( )
    ////                .filter(o -> o.isSupport(operator)).findFirst( );
    //        Operation op2 = op.orElseThrow(IllegalArgumentException::new);
    //        return op2.operate(first, second);
    //    }


}

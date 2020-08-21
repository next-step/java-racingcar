package pobiStringCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StringCalculator {
    private static List<Operation> operations = new ArrayList<>();
    static {
        operations.add(new PlusOperation());
        operations.add(new MinusOperation());
        operations.add(new MultiOperation());
        operations.add(new DividOperation());

    }
    public static int calculate(String value) {
        String[] values = value.split(" ");
        int result = toInt(values[0]);
        for (int i = 1 ; i < values.length; i+=2){
            // 0 아닌 1 (base 이미 result values[0]), ++(+1)아닌 +=2, 연산자와 정수 구분
            String operator = values[i];
            int second = toInt(values[i+1]);
            result = calculate(result, second, operator);
        }
        return result;

    }

    private static int calculate(int first, int second, String operator) {
        //operations.stream() local variable선언 시 Optional<Operation> 자동 반환 : 에러값not Operation고려해 지정
        Optional<Operation> op = operations.stream( )
                .filter(o -> o.isSupport(operator)).findFirst( );
        Operation op2 = op.orElseThrow(IllegalArgumentException::new);
        return op2.operate(first, second);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);  // i, values -> value
    }
}

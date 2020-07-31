import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:04 오후
 */
public class StringCalculatorTest {

    private static Map<String, String> operator = new HashMap<>();
    static {
        operator.put("+", "PLUS");
        operator.put("-", "MINUS");
        operator.put("/", "DIVISION");
        operator.put("*", "MULTIPLY");
    }

    @ParameterizedTest
    //@ValueSource(strings = {"2 + 3"})
    //@ValueSource(strings = {"115 + 1000 * 187 - 237"})
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    public void test(String fourArithmeticOperations) {
        String[] arguments = fourArithmeticOperations.split(" ");


        int length = arguments.length;
        int answer = Integer.parseInt(arguments[0]); // 첫 숫자 초기화

        for (int i = 1; i < length; i += 2) {
            nullValidation(arguments[i]);
            operatorValidation(arguments[i]);
            answer = calculate(answer, arguments[i], Integer.parseInt(arguments[i+1]));
        }
        System.out.println(answer);
    }

    private int calculate(int answer, String operation, int nextNum) {
        return Operation.valueOf(operator.get(operation)).calculate(answer, nextNum);
    }

    private void nullValidation(String str) {
        if (str.equals(" ")) {
            System.out.println("nullValidation");
            throw new IllegalArgumentException();
        }
    }

    private void operatorValidation(String operatoration) {
        if (operator.get(operatoration) == null) {
            System.out.println("operation");
            throw new IllegalArgumentException();
        }
    }

}

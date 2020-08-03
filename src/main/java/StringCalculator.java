import java.util.HashMap;
import java.util.Map;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:49 오전
 */
public class StringCalculator {
    private static Map<String, String> operator = new HashMap<>();
    static {
        operator.put("+", "PLUS");
        operator.put("-", "MINUS");
        operator.put("/", "DIVISION");
        operator.put("*", "MULTIPLY");
    }

    public static void main(String[] args) {

        String fourArithmeticOperations = "2 + 3 * 4 / 2";
        String[] arguments = fourArithmeticOperations.split(" ");

        int length = arguments.length;
        int answer = Integer.parseInt(arguments[0]); // 첫 숫자 초기화

        StringCalculator stringCalculator = new StringCalculator();
        int solution = stringCalculator.answer(arguments, length, answer);

        System.out.println(solution);
    }

    public int answer(String[] arguments, int length, int answer) {

        for (int i = 1; i < length; i += 2) {
            answer = calculate(answer, arguments[i], Integer.parseInt(arguments[i+1]));
        }

        return answer;
    }

     private static int calculate(int answer, String operation, int nextNum) {
        return Operation.valueOf(operator.get(operation)).calculate(answer, nextNum);
    }
}

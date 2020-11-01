package secondStage;

import java.util.ArrayList;
import java.util.List;

/**
 * 단위 테스트가 목적인 단계라서 클래스 분리 및 불변객체, 캐싱, 응집도와 같은 것은 생각하지 않았습니다.
 * 아래와 같은 분리만 생각하였습니다.
 *
 * - 문자열 분리 기능
 * - 피연산자를 추출하는 기능
 * - 연산자를 추출하는 기능
 * - 사칙연산 기능
 */
public class StringCalculator {

    /**
     * 사칙연산
     */
    public static int calculator(String str) {
        validate(str);
        String[] values = split(str);
        List<Integer> operands = createOperands(values);
        List<String> operators = createOperators(values);;

        int result = operands.get(0); // 처음 값 셋팅;
        // 연산자 루프
        for (int i = 0; i < operators.size(); i++) {
            // 피연산자 루프
            if ("+".equals(operators.get(i))) {
                result += operands.get(i+1);
            } else if ("-".equals(operators.get(i))) {
                result -= operands.get(i+1);
            } else if ("*".equals(operators.get(i))) {
                result *= operands.get(i+1);
            } else if ("/".equals(operators.get(i))) {
                result /= operands.get(i+1);
            }
        }

        return result;
    }

    /**
     * 피연산자 생성
     */
    protected static List<Integer> createOperands(String[] values) {
        List<Integer> operands = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                operands.add(Integer.parseInt(values[i]));
            }
        }

        return operands;
    }

    /**
     * 연산자 생성
     */
    protected static List<String> createOperators(String[] values) {
        List<String> operators = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            if (i % 2 != 0) {
                operators.add(values[i]);
            }
        }

        return operators;
    }

    /**
     * 문자열 split
     */
    protected static String[] split(String str) {
        return str.split(" ");
    }

    /**
     * 모든 검증
     */
    protected static void validate(String str) {
        validateNone(str);
        validateOperate(str);
    }

    /**
     * 문자열의 null, empty 예외
     */
    protected static void validateNone(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null은 사용할 수 없습니다.");
        }

        if (str.isEmpty()) {
            throw new IllegalArgumentException("빈 값은 사용할 수 없습니다.");
        }
    }

    /**
     * 사칙연산의 기호가 아닌 경우 예외
     */
    protected static void validateOperate(String str) {
        String[] values = split(str);
        List<String> operators = createOperators(values);

        for (String operator : operators) {
            if (!("+".equals(operator) || "-".equals(operator) || "*".equals(operator)|| "/".equals(operator))) {
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
            }
        }
    }
}

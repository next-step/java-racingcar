package step2;

public class StringCalculatorUtils {

    private StringCalculatorUtils() {
    }

    /**
     * 공백을 모두 제거
     * 
     * @param param : String, 공백을 제거할 문자열
     * @return String, 공백이 제거된 문자열
     */
    public static String removeWhiteSpace(String param) {
        return param.replaceAll(" ", "");
    }

    /**
     * 뺄샘일 경우 operator가 비어있음. 해당 경우 + 연산자로 변환 (a - b = a + -b)
     * 
     * @param operator : String, 연산자
     * @param right    : String, 수식의 우항
     * @return String, operator가 비어있고 right가 음수인 경우 + 반환, 아닐 경우 operator 그대로 반환
     */
    public static String getNegativeCheckedOperator(String operator, String right) {
        if (operator.isEmpty() && right.charAt(0) == '-') {
            return "+";
        }
        return operator;
    }
}

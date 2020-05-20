package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator extends Calculator {
    private static final Pattern PATTERN_FIND_NUMBER = Pattern.compile("-?\\d*\\.{0,1}\\d+");

    /**
     * 문자열 안의 숫자와 연산자를 분리하여 계산한다.
     * 
     * @param param : String, '숫자 연산자 숫자' 의 순서로 이루어진 문자열 e.g."2 + 3 + 4"
     * @return 계산 결과 값을 반환한다.
     */
    public String calculateString(String param) {
        String left = "";
        String right = "";
        String operator = "";

        try {
            StringValidator.checkNull(param);
            param = StringCalculatorUtils.removeWhiteSpace(param);

            Matcher matcher = PATTERN_FIND_NUMBER.matcher(param);
            matcher.find();

            left = matcher.group();
            StringValidator.checkNumber(left);

            for (int i = matcher.end(); i < param.length(); i = matcher.end()) {
                matcher.find(i);

                right = matcher.group();
                StringValidator.checkNumber(right);

                operator = param.substring(i, matcher.start());
                operator = StringCalculatorUtils.getNegativeCheckedOperator(operator, right);
                StringValidator.checkOperator(operator);

                left = String.valueOf(calculate(operator, Double.parseDouble(left), Double.parseDouble(right)));
            }

            return getCheckedResult(left);

        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("잘못된 연산식" + "\nparam : " + param);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + "\nparam : " + param);
        }

    }

    /**
     * 연산 결과가 int면 소수점을 빼고 반환
     * 
     * @param result : String, 연산 결과
     * @return String, double 혹은 int 모양의 숫자 문자열 반환
     */
    private String getCheckedResult(String result) {
        double doubleResult = Double.parseDouble(result);

        if (doubleResult % 1 == 0) {
            return String.valueOf((int) doubleResult);
        }

        return result;
    }
}

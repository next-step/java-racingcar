import org.apache.commons.lang3.StringUtils;

public class StringCalculator {

    // 덧셈
    private int doAddition(int first, int second) {
        return first + second;
    }

    // 뺄셈
    private int doSubtraction(int first, int second) {
        return first - second;
    }

    // 곱셈
    private int doMultiplication(int first, int second) {
        return first * second;
    }

    // 나눗셈
    private int doDivision(int first, int second) {
        return first / second;
    }

    public int calculate(String parameter) {

        int result;

        // parse parameter
        String[] parsedParameter = parseParameter(parameter);

        // check parameter validation
        assertValidParameter(parsedParameter);

        // calculate
        int i = 0;
        result = Integer.valueOf(parsedParameter[i]);

        while (i+2 <= parsedParameter.length) {
            int variable = Integer.valueOf(parsedParameter[i+2]);
            Character operator = parsedParameter[i+1].charAt(0);

            switch (operator) {
                case '+' :
                    result = doAddition(result, variable);
                    break;
                case '-' :
                    result = doSubtraction(result, variable);
                    break;
                case '*' :
                    result = doMultiplication(result, variable);
                    break;
                case '/' :
                    result = doDivision(result, variable);
                    break;
            }
            i+=2;
        }

        return result;
    }

    // 입력값 체크
    public Boolean assertValidParameter(String[] parsedParameter) {

        for (int i = 0; i < parsedParameter.length; ++i) {
            if (StringUtils.isBlank(parsedParameter[i])) {
                throw new IllegalArgumentException();
            }

            String current = parsedParameter[i];
            if ((i+2)%2 == 0 && (!StringUtils.isNumeric(current))) {
                throw new IllegalArgumentException();
            }

            if ((i+2)%2 == 1 && (!isValidFourArithmeticOperator(current))) {
                throw new IllegalArgumentException();
            }
        }

        return true;
    }

    public String[] parseParameter(String parameter) throws IllegalArgumentException {
        return parameter.split(" ");
    }

    // 사칙연산 기호 체크
    public Boolean isValidFourArithmeticOperator(String character) {

        Character operator = character.charAt(0);

        // 문자인지 체크
        if (Character.isDigit(operator)) {
            return false;
        }

        // 사칙연산 operator가 맞는지 체크
        switch (operator) {
            case '+' :
            case '-' :
            case '*' :
            case '/' :
                    return true;
        }

        return false;
    }
}
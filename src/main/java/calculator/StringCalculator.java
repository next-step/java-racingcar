package calculator;

import java.util.ArrayList;

public class StringCalculator {

    private static final String BLANK = " ";

    /**
     * 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기
     * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
     * 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
     *
     * @param inputText
     * @return Integer
     */
    public Integer computerCalculator(String inputText) {

        ArrayList<String> calculatorArrayList = new ArrayList<>();

        calculatorArrayList = getCalculatorDataElements(inputText);

        String operator = "";

        Integer result = 0;

        Integer tempInteger = 0;

        for (String contents : calculatorArrayList) {
            if (isNumber(contents)) {
                tempInteger = Integer.parseInt(contents);
                if(operator.equals("")){
                    result = tempInteger;
                }else {
                    Operation operation = Operation.findOperation(operator);
                    switch (operation) {
                        case PULS:
                        case MINUS:
                        case DIVIDE:
                            if (tempInteger == 0) {
                                throw new ArithmeticException();
                            }
                        case MULTIPLY:
                            result = operation.apply(result, tempInteger);
                            break;
                        default:
                            result = tempInteger;
                            break;
                    }
                    operator = "";
                }
            } else {
                operator = contents;
            }
        }
        return result;
    }

    /**
     * 입력한 문자열을 ArrayList로 변환한다.
     * 변환하는 과정에서 공백을 제거하고 숫자와 사칙연산자 외 입력된 문자열은 IllegalArgumentException 처리
     *
     * @param inputString
     * @return
     */
    ArrayList<String> getCalculatorDataElements(String inputString) {

        char[] inputCharArray = inputString.replace(BLANK, "").toCharArray();

        validateInputChars(inputCharArray);

        ArrayList<String> returnArrayList = new ArrayList<String>();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputCharArray.length; i++) {
            char c = inputCharArray[i];

            if (isOperator(String.valueOf(c))) {
                if (stringBuilder.length() > 0) {
                    returnArrayList.add(stringBuilder.toString());
                    stringBuilder.setLength(0);
                    returnArrayList.add(String.valueOf(c));
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                stringBuilder.append(c);
            }
        }

        if (stringBuilder.length() > 0) {
            returnArrayList.add(stringBuilder.toString());
        }

        return returnArrayList;
    }

    /**
     * 입력된 char[] 유효성 확인
     *
     * @param chars
     */
    void validateInputChars(char[] chars) {

        if (chars.length == 0) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            validateInputString(String.valueOf(aChar));
        }
    }

    /**
     * 입력된 문자열이 숫자와 사칙연산자가 아닌 경우 Exception 처리
     *
     * @param str
     */
    void validateInputString(String str) {

        if (!isNumber(str) && !isOperator(str)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 문자열이 숫자인지 확인
     *
     * @param str
     * @return
     */
    boolean isNumber(String str) {
        return str.matches("^[0-9]*$");
    }

    /**
     * 문자열이 사칙연산자 인지 확인
     *
     * @param str
     * @return
     */
    boolean isOperator(String str) {
        return str.matches("^[+-/*]$");
    }

    public static StringCalculator create(){
        return new StringCalculator();
    }
}

package StringCalculator;

/**
 * 문자열 계산기
 */
public class StringCalculator {

    /**
     * 문자열 계산
     * @param input 들어올 문자열
     * @return 계산값
     */
    public int calculate(String input) {
        isEmpty(input);
        String[] value = stringToArray(input);

        int beforeNum = stringToInt(value[0]);

        for(int i = 1; i < value.length; i += 2) {
            int afterNum = stringToInt(value[i + 1]);
            Operator operator = Operator.setOperator(value[i]);
            beforeNum = operator.calculate(beforeNum, afterNum);
        }
        return beforeNum;
    }

    /**
     * 빈 값 체크
     * @param input 받을 문자열
     */
    private void isEmpty(final String input) {
        if(input == null || input.trim().equals("")) {
            throw new IllegalArgumentException("Can not input EMPTY value");
        }
    }

    /**
     * 띄어쓰기를 기준으로 string -> array
     * @param input 받을 문자열
     * @return 배열 형태
     */
    private String[] stringToArray(String input) {
        return input.split(" ");
    }

    /**
     * string -> int
     * @param input 받을 문자열
     * @return int형 숫자
     */
    public int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}

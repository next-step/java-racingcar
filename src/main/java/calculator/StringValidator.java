package calculator;

/**
 * 문자열 계산기 입력값 유효성 검증 클래스
 */
public class StringValidator {

    /**
     * 입력값 유효성 검증
     * @param input 입력값
     * @return 유효하면 true, 유효하지 않으면 IllegalArgumentException
     */
    public boolean valid(String input) {
        if (input == null || input.isEmpty() || input.matches("\\s+")) {
            throw new IllegalArgumentException();
        }
        String regex = "^[0-9\\s+\\-*/]*$";
        if (!input.matches(regex)) {
            throw new IllegalArgumentException();
        }
        return true;
    }

}

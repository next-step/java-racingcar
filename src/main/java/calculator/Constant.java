package calculator;

public class Constant {

    static final String INPUT_REQUEST = "계산할 문구를 넣어주세요. (ex. 2 + 3 * 4 / 2)";
    static final String INTERNAL_ERROR = "시스템 내부적인 에러가 발생했습니다.";
    static final String ERROR_INPUT_SIZE = "[ERROR] 정확한 계산 문구를 입력해주세요.";
    static final String ERROR_OPERATOR = "[ERROR] 연산자는 + - * / 만 가능합니다.";
    static final String ERROR_OPERAND = "[ERROR] 피연산자는 숫자만 입력해주세요.";
    static final String RESULT = "결과값은 ";
    static final String FINAL_SENTENCE = " 입니다.";
    static final int OPERATOR_START_INDEX = 1;
    static final int OPERAND_START_INDEX = 0;
    static final int MIN_INPUT_SIZE = 3;
}

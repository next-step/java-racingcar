package calculator;

import java.util.Objects;

public class InputVo {

    private static final String BLANK = " ";
    /**
     * this.input을 공백을 기준으로 split 한 배열
     */
    private String[] inputSplit;

    public InputVo(String input) {
        validate(input);
        splitInput(input);
    }

    private void validate(String input) {
        if (Objects.equals(input, null)) {
            throw new IllegalArgumentException("null 값 입력 됨");
        }

        if (Objects.equals(input, " ")) {
            throw new IllegalArgumentException("공백 값 입력 됨");
        }
    }

    /**
     * input값을 공백을 기준으로 나누어줌
     */
    private void splitInput(String input) {
        this.inputSplit = input.split(BLANK);
    }


    public String[] getInputSplit() {
        return inputSplit;
    }
}

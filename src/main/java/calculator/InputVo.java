package calculator;

public class InputVo {
    /**
     * 입력 값
     */
    private String input;
    /**
     * this.input을 공백을 기준으로 split 한 배열
     */
    private String[] inputSplit;


    public InputVo() {
    }

    public InputVo(String input) {
        this.input = input;
        validate(input);
        splitInput();
    }

    /**
     * validate
     */
    private void validate(String input) {
        if (input == null) {
            throw new IllegalArgumentException("null 값 입력 됨");
        }

        if (input.trim().equals("")) {
            throw new IllegalArgumentException("공백 값 입력 됨");
        }
    }

    /**
     * input값을 공백을 기준으로 나누어줌
     */
    private void splitInput() {
        this.inputSplit = this.input.split(" ");
    }


    public String[] getInputSplit() {
        return inputSplit;
    }
}

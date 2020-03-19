package racingcar;

public class InputView {
    private int carCount;
    private int tryCount;

    public InputView(String input, InputType inputType) {
        validateNull(input);
        validateEmpty(input);
        validateNumber(input);
    }

    private void validateNull(String input){
        if(input == null){
            throw new IllegalArgumentException("null은 입력할 수 없습니다.");
        }
    }

    private void validateEmpty(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException("공백 문자열은 입력할 수 없습니다.");
       }
    }

    private void validateNumber(String input){
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException nfe){
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}

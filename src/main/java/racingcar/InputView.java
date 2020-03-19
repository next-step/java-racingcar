package racingcar;

public class InputView {
    private int carCount;
    private int tryCount;

    public InputView(String input) {
        validateNull(input);
        validateEmpty(input);
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
}

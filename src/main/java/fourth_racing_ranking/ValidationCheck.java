package fourth_racing_ranking;

public class ValidationCheck {
    private static final int RACING_CAR_MIN_NO = 1;

    public boolean valdationCarName(String input) {
        if(!nullCheck(input)){
            throw new IllegalArgumentException("공백금지");
        }

        if(!spltCheck(input)) {
            throw new IllegalArgumentException("구분자확인");
        }

        return true;
    }

    public boolean valdationTryNumber(int input) {
        if (input < RACING_CAR_MIN_NO ){
            throw new IllegalArgumentException(RACING_CAR_MIN_NO + " 이상의 숫자를 입력하세요");
        }
        return true;
    }

    public boolean nullCheck(String input){
        if (input == null || "".equals(input.replace(" ", ""))){
            return false;
        }

        return true;
    }

    public boolean spltCheck(String input){
        if (SetInputValue.splitCarName(input).length == 1){
            return false;
        }

        return true;
    }
}

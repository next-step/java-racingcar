package fifth_refactoring.view;

import fifth_refactoring.domain.CarAction;

public class CheckValidation {
    private static final int RACING_CAR_MIN_NO = 1;

    public boolean validateCarName(String input) {
        if(!checkNull(input)){
            throw new IllegalArgumentException("공백금지");
        }

        if(!checkSplit(input)) {
            throw new IllegalArgumentException("구분자확인");
        }

        return true;
    }

    public boolean validateTryNumber(int input) {
        if (input < RACING_CAR_MIN_NO ){
            throw new IllegalArgumentException(RACING_CAR_MIN_NO + " 이상의 숫자를 입력하세요");
        }
        return true;
    }

    public boolean checkNull(String input){
        return input != null && !"".equals(input.replace(" ", ""));
    }

    public boolean checkSplit(String input){
        return CarAction.splitCarName(input).length != 1;
    }
}

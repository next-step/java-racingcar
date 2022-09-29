package racingGame.view;

import racingGame.exception.WrongInputException;

import java.util.regex.Pattern;

public class InputVerifier {
    private static final Pattern tryFilter = Pattern.compile("^([0-9]+)$");
    private static final Pattern carNameFilter = Pattern.compile("^([a-zA-Z가-힣,]+)$");
    private static final String splitMark = ",";
    public static void validateTryInput(String tryNum) {
        if (!tryFilter.matcher(tryNum).matches()) {
            throw new WrongInputException("숫자를 입력해주세요");
        }
    }

    public static void validateNameInput(String carNames){
        if (!carNameFilter.matcher(carNames).matches()){
            throw new  WrongInputException("올바른 이름을 입력해주세요.");
        }
    }
}

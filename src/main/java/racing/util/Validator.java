package racing.util;

public class Validator {

    public static void validateCarNames(String carNamesString){
        if(carNamesString.isBlank())
            throw new IllegalArgumentException("자동차 이름은 존재해야 합니다");
    }
}

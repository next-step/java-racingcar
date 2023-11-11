package racingcar.common.utils;

public class TextLimitSizeValidator {

    private TextLimitSizeValidator(){}

    public static boolean isOverLimitSize(String text, int limitSize){
        return text.length() > limitSize;
    }

}

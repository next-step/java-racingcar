package study.step2;

import java.util.Arrays;

public class StringValidator {
    public static final String SPLIT_DELIMITER=" ";
    public static final Integer CAR_NAME_LENGTH_LIMIT=5;
    public static final String CAR_NAME_SPLIT_DELIMITER=",";
    private static final String NUMBER_CHECK_REGEX="^[0-9]+$";

    public static boolean isBlank(String input){
        return (input == null || input.trim().isEmpty());
    }

    public static void checkNumberSyntax(String input){
        if(!input.matches(NUMBER_CHECK_REGEX)) throw new NumberFormatException("숫자를 정확히 입력해주세요");
    }
    public static void checkCarNameSyntax(String input){
        if(Arrays.stream(input.split(CAR_NAME_SPLIT_DELIMITER))
                .filter(name -> name.length() > CAR_NAME_LENGTH_LIMIT)
                .count() > 0) throw new StringIndexOutOfBoundsException("차 이름의 길이는 5자를 초과할 수 없습니다.");
    }

}

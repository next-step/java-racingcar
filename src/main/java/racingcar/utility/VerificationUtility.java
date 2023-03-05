package racingcar.utility;

import java.util.Arrays;
import java.util.HashSet;

public class VerificationUtility {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private VerificationUtility() {
    }

    public static void validateCarName(String Name) {
        if (Name == null) {
            throw new IllegalArgumentException("자동차 이름은 null 일 수 없습니다.");
        }

        validateCarNameLength(Name);
        validateCarNameSpace(Name);
    }

    private static void validateCarNameLength(String Name) {
        if (Name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException("1글자 이상이어야 합니다.");
        }

        if (Name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("5글자 이하이어야 합니다.");
        }
    }

    private static void validateCarNameSpace(String Name) {
        if (Name.contains(" ")){
            throw new IllegalArgumentException("공백 제거 필요");
        }
    }

    public static void validateDuplication(String[] Names) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(Names));

        if (hashSet.size() < Names.length) {
            throw new IllegalArgumentException("이름 중복 제거 필요");
        }
    }


    public static int validateAttempt(String attempt) {
        int number = translateVerifiedInteger(attempt);
        validatePositiveNumber(number);

        return number;
    }

    private static int translateVerifiedInteger(String attempt) {
        try {
            return Integer.parseInt(attempt);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자 입력 필요");
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수 입력 필요");
        }
    }
}

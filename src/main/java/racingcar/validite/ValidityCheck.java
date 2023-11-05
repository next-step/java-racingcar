package racingcar.validite;

import java.util.List;

public class ValidityCheck {

    private static final int INPUT_CONDITION_NUMBER = 0;
    private static final int CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_SPLIT = ",";

    public static int positiveNumberCheck(Integer number) {
        try {
            return checkNumberSize(number);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static int checkNumberSize(Integer number) {
        if (number >= INPUT_CONDITION_NUMBER) {
            return number;
        }
        throw new IllegalArgumentException("0보다 큰 숫자를 입력해주세요.");
    }

    public static List<String> carNameCheck(String carNames) {
        List<String> carNameList = List.of(carNames.split(CAR_NAME_SPLIT));
        for (String name : carNameList) {
            carNameLengthCheck(name);
        }
        return carNameList;
    }

    private static String carNameLengthCheck(String name) {
        if (nameLengthBoolean(name)) {
            return name;
        }
        throw new IllegalArgumentException("자동차 이름은 5자를 초과 할 수 없습니다.");
    }

    private static boolean nameLengthBoolean(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 없는 경우가 있습니다.");
        }
        if (name.length() > CAR_NAME_LENGTH) {
            return false;
        }
        return true;
    }
}

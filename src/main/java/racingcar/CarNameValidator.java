package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarNameValidator {

    private static int MAXIMUM_NAME_LENGTH = 5;

    private CarNameValidator() {
    }

    public static List<String> carNameValidation(String originNames) {
        originNames = removeTrim(originNames);
        List<String> names = Arrays.asList(originNames.split(","));
        nameValidation(names);
        return names;
    }

    private static String removeTrim(String originNames) {
        originNames = originNames.replace(" ", "");
        return originNames;
    }

    private static void nameValidation(List<String> names) {
        names.forEach(CarNameValidator::nameLengthValidation);
    }

    private static void nameLengthValidation(String name) {
        if (name.trim().length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}

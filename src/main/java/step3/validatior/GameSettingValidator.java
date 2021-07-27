package step3.validatior;

import java.util.List;
import step3.exception.WrongGameSettingException;

public class GameSettingValidator {

    private static final int CAR_NAME_MAX_LENGTH = 5;

    private static GameSettingValidator validator = new GameSettingValidator();

    private GameSettingValidator() {
    }

    public static GameSettingValidator getInstance() {
        return validator;
    }

    public void validateCarNames(List<String> carNames) {
        carNames.stream().forEach(this::checkCarNameLength);
    }

    private void checkCarNameLength(String carName) {
        try {
            checkStringMaxLength(carName, CAR_NAME_MAX_LENGTH);
        } catch (IllegalArgumentException e) {
            throw new WrongGameSettingException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    private void checkStringMaxLength(String string, int maxLength)
        throws IllegalArgumentException {
        if (string.length() > maxLength) {
            throw new IllegalArgumentException();
        }
    }
}

package racingCar.view.validator;

import racingCar.util.validator.GeneralValidator;
import racingCar.util.validator.StringValidator;

public class InputValidator {
    private static final String PLAYER_FORMAT_IS_INVALID = "플레이어의 이름은 ,로 구분된 형식으로 입력해야합니다. 예) pobi,crong,honux";
    private static InputValidator inputValidator;

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        if (inputValidator == null) {
            return new InputValidator();
        }
        return inputValidator;
    }

    public void validatePlayerGroup(String separator, String playerGroup) {
        StringValidator.validateBlank(playerGroup, PLAYER_FORMAT_IS_INVALID);
        validateValidSeperator(separator, playerGroup, PLAYER_FORMAT_IS_INVALID);
    }

    private void validateValidSeperator(String separator, String value, String message) {
        GeneralValidator.validateDuplicateSubstring(separator, value, message);
        GeneralValidator.validateStartSubstring(separator, value, message);
        GeneralValidator.validateEndSubstring(separator, value, message);
    }
}

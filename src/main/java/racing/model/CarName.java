package racing.model;

import calculator.util.StringUtils;
import racing.exception.GameReadyException;

public class CarName {

    public static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(final String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        validateNullOrEmpty(name);
        validateLongName(name);
    }

    private static void validateNullOrEmpty(final String name) {
        if (StringUtils.hasNotText(name)) {
            throw new GameReadyException("자동차 이름을 입력하지 않았습니다.");
        }
    }

    private static void validateLongName(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new GameReadyException("자동차 이름은 " + MAX_LENGTH + "자 이하만 가능합니다.");
        }
    }
}

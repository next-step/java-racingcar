package racingcar.car;

import racingcar.exception.GameException;

public class CarName {

    private final String name;

    private CarName(String name) {
        String trimmed = name.trim();
        if (trimmed.isEmpty() || trimmed.length() > 5) {
            throw new GameException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
        this.name = trimmed;
    }

    public static CarName of(String name) {
        return new CarName(name);
    }

    public String getName() {
        return name;
    }
}

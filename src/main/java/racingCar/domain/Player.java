package racingCar.domain;

import racingCar.domain.validator.PlayerValidator;

public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public static Player from(String name) {
        PlayerValidator.validate(name);
        return new Player(name);
    }
}

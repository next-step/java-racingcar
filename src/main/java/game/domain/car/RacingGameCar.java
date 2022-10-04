package game.domain.car;

import game.domain.RacingGameRule;

public class RacingGameCar extends Car {

    private static int NAME_LIMIT_LENGTH = 5;
    private static String NAME_LIMIT_MESSAGE = "자동차 이름은 " + NAME_LIMIT_LENGTH + "자를 초과할 수 없다";

    public RacingGameCar() {
    }

    public RacingGameCar(String name) {
        super(checkNameLength(name));
    }

    public RacingGameCar(RacingGameCar racingGameCar) {
        super(racingGameCar.name());
    }

    @Override
    public void forward(RacingGameRule racingGameRule, int number) {
        if (racingGameRule.isForward(number)) {
            forward(racingGameRule.forwardDistance());
        }
    }

    public void forward(int number) {
        location += number;
    }

    private static String checkNameLength(String name) {
        if (name.length() > 5) {
            throw new RuntimeException(NAME_LIMIT_MESSAGE);
        }
        return name;
    }

}

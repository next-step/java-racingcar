package game.domain.car;

import game.domain.rule.RacingGameRule;

public class RacingGameCar extends Car {

    public RacingGameCar() {
    }

    public RacingGameCar(String name) {
        super(name);
    }

    public RacingGameCar(RacingGameCar racingGameCar) {
        super(racingGameCar.carName().getCarName());
    }

    @Override
    public void forward(RacingGameRule racingGameRule, int number) {
        if (racingGameRule.isForward(number)) {
            forward(racingGameRule.forwardDistance());
        }
    }

    public void forward(int number) {
        location.forward(number);
    }
}

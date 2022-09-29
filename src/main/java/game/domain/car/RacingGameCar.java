package game.domain.car;

import game.domain.RacingGameRule;
import game.domain.car.Car;

public class RacingGameCar extends Car {

    public RacingGameCar() {
    }

    public RacingGameCar(String name) {
        super(checkNameLength(name));
    }

    @Override
    public void forward(RacingGameRule racingGameRule) {
        if (racingGameRule.isForward(racingGameRule.pickRandomNumber())) {
            forward(racingGameRule.forwardDistance());
        }
    }

    public void forward(int number) {
        location += number;
    }

    private static String checkNameLength(String name) {
        if(name.length()>5){
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없다");
        }
        return name;
    }

}

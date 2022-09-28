package game.domain;

public class RacingGameCar extends Car {

    @Override
    public void forward(RacingGameRule racingGameRule) {
        if (racingGameRule.isForward(racingGameRule.pickRandomNumber())) {
            forward(racingGameRule.forwardDistance());
        }
    }

    public void forward(int number) {
        location += number;
    }

}

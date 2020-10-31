package step3.car;

import step3.game.RacingGame;

public class RacingCar implements Car {
    private final StringBuilder skidMark = new StringBuilder();

    public RacingCar() {
    }

    @Override
    public void go(RacingGame game) {
        if (allowMove(game.getNumber())) {
            skidMark.append("-");
        }
    }

    public StringBuilder getSkidMark() {
        return skidMark;
    }
}

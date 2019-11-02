package step1.racing;

public class RacingGame {
    private final Moveable moveStrategy;
    private final RacingCarHandler racingCarHandler;

    public RacingGame(RacingCarHandler racingCarHandler, Moveable moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.racingCarHandler = racingCarHandler;
    }

    public void move() {
        racingCarHandler.race(moveStrategy);
    }
}

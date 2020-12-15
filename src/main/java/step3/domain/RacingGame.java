package step3.domain;

import step3.domain.rule.MoveRule;

public class RacingGame {
    private int roundTime;
    private Cars cars;
    private MoveRule moveRule;

    public RacingGame(int roundTime, int carCount, MoveRule moveRule) {
        this.roundTime = roundTime;
        this.moveRule = moveRule;
        this.cars = new Cars(carCount);
    }

    public void play() {
        for(int i = 0; i < this.roundTime; i++) {
            cars.moveAll(i, moveRule);
        };
    }
}

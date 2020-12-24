package step3.domain;

import step3.domain.rule.MoveRule;

public class RacingGame {
    private int roundCount;
    private Cars cars;
    private MoveRule moveRule;

    public RacingGame(int roundCount, String[] carNames, MoveRule moveRule) {
        this.roundCount = roundCount;
        this.moveRule = moveRule;
        this.cars = new Cars(carNames);
    }

    public void play() {
        for(int i = 0; i < this.roundCount; i++) {
            cars.moveAll(i, moveRule);
        };
    }

    public Cars getCars() {
        return cars;
    }
}

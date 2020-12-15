package step3.domain;

import step3.domain.rule.MoveRule;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int roundTime;
    private List<Car> cars = new ArrayList<>();
    private MoveRule moveRule;

    public RacingGame(int roundTime, int carCount, MoveRule moveRule) {
        this.roundTime = roundTime;
        this.moveRule = moveRule;
        for(int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void play() {
        for(int i = 0; i < this.roundTime; i++) {
            for(Car car : cars) {
                car.move(i, moveRule.canMove());
            }
        };
    }
}

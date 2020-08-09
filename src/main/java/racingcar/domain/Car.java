package racingcar.domain;

import racingcar.strategy.DoRace;
import racingcar.strategy.RaceCondition;

public class Car {
    private int position;

    public Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public int move(RaceCondition raceCondition, DoRace doRace) {
        if (raceCondition.pass()) {
            return position += doRace.race();
        } return position;
    }
}

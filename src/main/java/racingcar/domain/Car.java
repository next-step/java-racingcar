package racingcar.domain;

import racingcar.strategy.DoRace;
import racingcar.strategy.RaceCondition;

import java.util.Objects;

public class Car {
    private Position position;

    public Car(Position position) {
        this.position = position;
    }

    /*
    public Position getPosition() {
        return position;
    }
    */

    public int getPosition() {
        return position.getPosition();
    }

    public void move(RaceCondition raceCondition, DoRace doRace) {
        position.increase(raceCondition, doRace);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}

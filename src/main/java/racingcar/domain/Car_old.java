package racingcar.domain;

import racingcar.strategy.DoRace;
import racingcar.strategy.RaceCondition;

import java.util.Objects;

import static racingcar.Constants.INIT_POSITION;

public class Car_old {
    private final Position position;

    public Car_old(){
        this(new Position(INIT_POSITION));}

    public Car_old(Position position) {
        this.position = position;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public void move(RaceCondition raceCondition, DoRace doRace) {
        position.increase(raceCondition, doRace);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Car_old car_old = (Car_old) o;
        return Objects.equals(position, car_old.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}

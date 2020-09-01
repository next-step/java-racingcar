package racingcar.domain.car;

import racingcar.domain.Position;
import racingcar.strategy.raceStrategy.DoRace;
import racingcar.strategy.condition.RaceCondition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static racingcar.utils.Constants.FORWARD_OK_COND_NUM;
import static racingcar.utils.Constants.INIT_POSITION;

public class Car {

    private final String carName;
    private Position position;
    private List<Integer> recordCarMove;

    public Car(String carName, Position position) {
        this.carName = carName;
        this.position = position;
        recordCarMove = new ArrayList<>();
    }

    public Car(String carName) {
        this (carName, new Position(INIT_POSITION));
    }

    public String getCarName() {
        return carName;
    }

    public void Car(Position position) {
        this.position = position;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public int getRecordCarMove(int i) {
        return recordCarMove.get(i);
    }

    public boolean equalToPosition(int maxPosition) {
       if (position.getPosition() == maxPosition) {
           return true;
       }
       return false;
    }

    public void move2(int movePoint){
        if (pass2(movePoint)) {
            position.increase2();
        }
        recordCarMove.add(position.getPosition());
    }

    private boolean pass2(int movePoint) {
        return movePoint >= FORWARD_OK_COND_NUM;
    }

//    public void move(RaceCondition raceCondition, DoRace doRace) {
//        position.increase(raceCondition, doRace);
//        recordCarMove.add(position.getPosition());
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) &&
                Objects.equals(position, car.position) &&
                Objects.equals(recordCarMove, car.recordCarMove);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position, recordCarMove);
    }
}

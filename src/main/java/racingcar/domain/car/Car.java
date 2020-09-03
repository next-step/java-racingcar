package racingcar.domain.car;

import java.util.Objects;

import static racingcar.utils.Constants.FORWARD_OK_COND_NUM;
import static racingcar.utils.Constants.INIT_POSITION;

public class Car {

    private final String carName;
    private int position = INIT_POSITION;

    public Car(String carName) {
        this.carName = carName;
    }

//    public Car(String carName) {
//        this (carName, INIT_POSITION));
//    }

    public String getCarName() {
        return carName;
    }

    public void Car(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }


    public boolean equalToMaxPosition(int maxPosition) {
        return position >= maxPosition;
    }

    public void move2(int movePoint){
        if (pass2(movePoint)) {
            position++;
        }
    }

    private boolean pass2(int movePoint) {
        return movePoint >= FORWARD_OK_COND_NUM;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass( ) != o.getClass( )) return false;
//        Car car = (Car) o;
//        return position == car.position &&
//                Objects.equals(carName, car.carName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(carName, position);
//    }
}

package study.racing.domain;

import java.util.Objects;

public class Car {

    private static final int INITIAL_POSITION = 0;
    public static final int MAX_CAR_NAME_LENGTH = 5;

    private int position;


    private String carName;

    public Car(String carName){

        validateCarName(carName);

        this.carName = carName;
        this.position = INITIAL_POSITION;
    }

    private static void validateCarName(String carName) {
        if(carName.length() > MAX_CAR_NAME_LENGTH){
            throw new IllegalArgumentException(RacingErrorMessage.OVER_MAX_NAME_LENGTH.getErrorMessage());
        }
    }

    public void move(RacingMoveStrategy racingMoveStrategy){
        position += racingMoveStrategy.getMovement();
    }

    public String getCarName(){return carName;}

    public Integer getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, carName);
    }
}


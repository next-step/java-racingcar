package racingcar.model;

import java.util.Objects;

public class Car {
    private final static int MAX_CAR_NAME = 5;

    private StringBuilder showCarDistance;

    private String carName;
    private int position = 0;

    public Car (String carName){
        this.carName = carName;
    }

    public Car (String carName, int position) {
        if(isOverFive(carName)){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.position = position;
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    private boolean isOverFive(String carName) {
        return carName.length() > MAX_CAR_NAME;
    }

    public boolean isMove(MovingStrategy movingStrategy){
        if(movingStrategy.movable()){
            position += 1;
            return true;
        }
        return false;
    }

    public int getDistance() {
        return this.position;
    }

    public String showCarDistance() {
        showCarDistance = new StringBuilder();
        for (int i = 0; i < position; i++) {
            showCarDistance.append("-");
        }
        return showCarDistance.toString();
    }

    public boolean isWinner(int maxPosition) {
        return maxPosition == getDistance();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(showCarDistance, car.showCarDistance) && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(showCarDistance, carName, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "showCarDistance=" + showCarDistance +
                ", carName='" + carName + '\'' +
                ", position=" + position +
                '}';
    }
}
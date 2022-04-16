package racingcar.model;

public class Car {
    private final static int MAX_CAR_NAME = 5;

    private StringBuilder showCarDistance;

    private String carName;
    private int distance = 0;

    public Car(String carName) {
        if(isOverFive(carName)){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
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
            distance += 1;
            return true;
        }
        return false;
    }

    public int getDistance() {
        return this.distance;
    }

    public String showCarDistance() {
        showCarDistance = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            showCarDistance.append("-");
        }
        return showCarDistance.toString();
    }

}

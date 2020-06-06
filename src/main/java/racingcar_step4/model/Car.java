package racingcar_step4.model;

public class Car implements Comparable<Car>{

    private static final int FORWARD_VALUE = 1;

    private String carName;
    private int totalDistance;

    public Car() {
    }

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int totalDistance) {
        this.carName = carName;
        this.totalDistance = totalDistance;
    }

    public int move(MovingStrategy movingStrategy) {
        if(movingStrategy.isMove()) {
            return totalDistance += FORWARD_VALUE;
        }
        return totalDistance;
    }

    public String getCarName() {
        return this.carName;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    @Override
    public int compareTo(Car car) {
        return this.totalDistance - car.totalDistance;
    }
}

package racingCar.domain;

import java.util.List;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    public static final int FORWARD_BOUNDARY_VALUE = 3;

    private String carName;
    private int forwardCount;

    public Car(String carName){
        checkCarName(carName);
        this.carName = carName;
        this.forwardCount = 0;
    }

    public Car(String carName, int forwardCount){
        checkCarName(carName);
        this.carName = carName;
        this.forwardCount = forwardCount;
    }

    public Car(int forwardCount) {
        this.forwardCount = forwardCount;
    }

    public String getCarName(){
        return carName;
    }

    public int getForwardCount() { return forwardCount; }

    private void checkCarName(String carName){
        if(carName.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException();
        }
    }

    private boolean isMoveCar(int inputValue){
        return inputValue > FORWARD_BOUNDARY_VALUE;
    }

    public void moveCar(int randomNumber){
        if(isMoveCar(randomNumber)) forwardCount++;
    }

    public int returnMaxCount(int maxForwardCount) {
        if(forwardCount >= maxForwardCount) return forwardCount;
        return maxForwardCount;
    }

    public List<String> addMaxForwardCar(int maxForwardCount, List<String> winners){
        if(forwardCount == maxForwardCount)
            winners.add(carName);

        return winners;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", forwardCount=" + forwardCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (forwardCount != car.forwardCount) return false;
        return carName != null ? carName.equals(car.carName) : car.carName == null;
    }

    @Override
    public int hashCode() {
        int result = carName != null ? carName.hashCode() : 0;
        result = 31 * result + forwardCount;
        return result;
    }
}

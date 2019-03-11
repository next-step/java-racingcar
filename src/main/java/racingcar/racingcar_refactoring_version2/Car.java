package racingcar.racingcar_refactoring_version2;

public class Car {

    private int movingDistance = 0;

    private String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMovingDistance() {
        return movingDistance;
    }

    public void moveCar() {
        movingDistance++;
    }


}

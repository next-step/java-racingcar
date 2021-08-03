package study.racingcar.domain;

public class Car {

    private int position;

    private String name;

    public Car() {

    }

    public Car(String name) {
        this.name = name;
    }

    public void moveCar(CarMovingStrategy carMovingStrategy) {
        if (carMovingStrategy.canMoveCar()) {
            position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

}

package racingcar.model;

public class Car {
    private int distance = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void move(boolean isMove) {
        if(isMove) {
            distance += 1;
        }
    }
}

package racingcar.model;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
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

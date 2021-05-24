package racingcar.domain;

public class Car {
    private String name;
    private int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void move() {
        RacingRandom racingRandom = new RacingRandom();
        if (racingRandom.isMove()) {
            this.location++;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocationInfo() {
        return location;
    }

}

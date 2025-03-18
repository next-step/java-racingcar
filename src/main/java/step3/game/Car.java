package step3.game;

public class Car {

    public static final int START_LINE = 0;

    private Integer moveSteps;
    public final CarName name;

    public Car(CarName name) {
        this.moveSteps = START_LINE;
        this.name = name;
    }

    public void move() {
        moveSteps++;
    }

    public Integer getDistance() {
        return moveSteps;
    }

    public String getCarName() {
        return name.getCarName();
    }
}

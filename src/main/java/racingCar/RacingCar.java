package racingCar;

public class RacingCar {

    private int position = 0;
    private String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void moveForward() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }
}
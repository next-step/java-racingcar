package racingGame.model;

public class RacingCar {
    private int position = 0;
    private String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        this.position += 1;
    }

    public String getName() {
        return this.name;
    }
}

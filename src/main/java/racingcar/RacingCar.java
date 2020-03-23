package racingcar;

public class RacingCar {
    private String name;
    private int position;

    private static int DEFAULT_POSITION = 0;

    public RacingCar(String name) {
        this(name, DEFAULT_POSITION);
    }

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        this.position++;
    }
}

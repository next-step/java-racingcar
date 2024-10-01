package racing;

public class RacingCar {
    private final String name;
    private final int position;

    public RacingCar(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

package racing;

public class RacingCar {

    private final String name;
    private int position;

    public RacingCar move(final int number) {
        return new RacingCar(name, this.position += number);
    }

    public static RacingCar init(final int key) {
        return new RacingCar(String.valueOf(key), 0);
    }

    public int getPosition() {
        return position;
    }

    private RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }
}

package racing;

public class RacingCar {

    private final String name;
    private int position;

    private RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static RacingCar init(final int key) {
        return new RacingCar(String.valueOf(key), 0);
    }

    public RacingCar move(final int number) {
        return new RacingCar(name, this.position += number);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}

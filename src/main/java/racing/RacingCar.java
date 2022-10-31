package racing;

public class RacingCar {

    public static final int MAX_NAME_SIZE = 5;

    private final int position;
    private final String name;

    private RacingCar(final int position, final String name) {
        this.position = position;
        this.name = name.length() > MAX_NAME_SIZE ? name.substring(0, MAX_NAME_SIZE) : name;
    }

    public static RacingCar init(final String name) {
        return new RacingCar(0, name);
    }

    public static RacingCar init(final int position, final String name) {
        return new RacingCar(position, name);
    }

    public RacingCar move(final int moveCount) {
        return new RacingCar(position + moveCount, name);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

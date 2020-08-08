package racingcar;

public class CarState {
    private final String name;
    private final int position;

    private CarState(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public static CarState makeCarState(String name, int position) {
        return new CarState(name, position);
    }
}

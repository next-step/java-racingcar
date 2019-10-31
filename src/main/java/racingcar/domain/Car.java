package racingcar.domain;

public class Car {

    private static final int INIT_LOCATION = 0;
    private static final int MOVE_CONDITION_NUMBER = 4;

    private String name;
    private int location;

    public Car(String name) {
        initialize(name, INIT_LOCATION);
    }

    public Car(String name, int location) {
        initialize(name, location);
    }

    private void initialize(String name, int location) {
        this.name = name;
        this.location = location;
    }

    void move(int number) {

        if (isPossibleMove(number)) {
            this.location++;
        }
    }

    private boolean isPossibleMove(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    boolean equalsLocation(int location) {
        return this.getLocation() == location;
    }
}

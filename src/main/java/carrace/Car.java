package carrace;

public class Car {
    private static final int GO = 1;
    private static final int STOP = 0;

    private final RandomMoving randomMoving = new RandomMoving();

    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public int race(int numberOfRaces) {
        int result = 0;
        for (int i = 0; i < numberOfRaces; i++) {
            result += move(randomMoving);
        }

        return result;
    }

    public int move(Moving moving) {
        return moving.isMove() ? GO : STOP;
    }

    public String getName() {
        return name;
    }
}

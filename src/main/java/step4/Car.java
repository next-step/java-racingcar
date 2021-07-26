package step4;

import step4.enums.MOVE;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private int location = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public int getLocation() {
        return this.location;
    }

    public String getName() {
        return name;
    }

    public void goOrStop() {
        int luckyNumber = RandomNumberGenerator.getRandomNumberGenerator().getRandomInt();

        if (MOVE.fromInt(luckyNumber).equals(MOVE.GO)) {
            this.progress();
        }
    }

    private void progress() {
        this.location += 1;
    }
}

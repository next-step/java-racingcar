package step3;

import step3.enums.MOVE;

public class Car {
    private int location = 0;

    public int getLocation() {
        return this.location;
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

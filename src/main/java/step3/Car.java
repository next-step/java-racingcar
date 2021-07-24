package step3;

import step3.enums.MOVE;

public class Car {
    private int location = 0;

    public int getLocation() {
        return this.location;
    }

    public void goOrStop() {
        MOVE move = MOVE.fromInt(RandomNumberGenerator.getRandomNumberGenerator().getRandomInt());

        if (move.equals(MOVE.GO)) {
            this.progress();
        }
    }

    private void progress() {
        this.location += 1;
    }
}

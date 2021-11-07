package racingcar.car;

import java.util.Collections;

public class Car {

    private int position;

    public void forward(int add) {
        this.position += add;
    }

    public int getPosition() {
        return this.position;
    }

    public String printPosition() {
        return String.join("", Collections.nCopies(this.position, "-"));
    }

    public void move(boolean isMovable, int moveCount) {
        if(isMovable) {
            this.forward(moveCount);
        }
    }
}

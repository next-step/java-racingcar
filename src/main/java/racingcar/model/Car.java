package racingcar.model;

import racingcar.model.action.RandomMovable;

public class Car {

    private int position;

    public void decideMovable() {
        RandomMovable randomMovableImple = new RandomMovable();
        int randomValue = randomMovableImple.makeRandomValue();
        if (randomMovableImple.MoveOrNot(randomValue)) {
            move();
        }
    }

    public void move() {
        position++;
    }

    public int getPoisition() {
        return position;
    }
}

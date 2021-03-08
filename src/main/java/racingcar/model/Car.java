package racingcar.model;

import racingcar.model.action.MovableImpl;

public class Car {

    private int position;

    public void decideMovable() {
        MovableImpl movableImple = new MovableImpl();
        int randomValue = movableImple.makeRandomValue();
        if (movableImple.MoveOrNot(randomValue)) {
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

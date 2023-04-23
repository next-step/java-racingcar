package racing;

import racing.domain.Car;
import racing.domain.Movable;

class CountingCar extends Car {

    private int moveCount;

    CountingCar(String name) {
        super(name);
    }

    @Override
    public void move(Movable movable) {
        super.move(movable);
        moveCount++;
    }

    int getMoveCount() {
        return moveCount;
    }

}

package racing;

import racing.movestrategies.MoveStrategy;

class Car {
    private MoveStrategy moveStrategy;
    private int position;

    Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.position = 0;
    }

    int getPosition() {
        return position;
    }

    void move() {
        if (moveStrategy.canIMove()) {
            this.position += 1;
        }
    }
}

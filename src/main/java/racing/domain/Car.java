package racing.domain;

import racing.rule.move.MoveStrategy;

public class Car {

    private int forwardCount = 1;


    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.move()) {
            this.forwardCount ++;
        }
    }

    public int getForwardCount() {
        return forwardCount;
    }
}
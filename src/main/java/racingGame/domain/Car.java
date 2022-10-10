package racingGame.domain;

import racingGame.strategy.MoveStrategy;

public class Car {
    private int moveCount;

    public void move(MoveStrategy moveStrategy){
        if(moveStrategy.moveAble()){
            this.moveCount++;
        }
    };

    public int getMoveCount() {
        return this.moveCount;
    }
}

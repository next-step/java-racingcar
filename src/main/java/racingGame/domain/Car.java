package racingGame.domain;

import racingGame.strategy.MoveStrategy;
import racingGame.strategy.NumberGenerateStrategy;

public class Car {

    private int moveCount;

    public void move(MoveStrategy moveStrategy, NumberGenerateStrategy numberGenerateStrategy){
        if(moveStrategy.moveable(numberGenerateStrategy.NumberGenerate())){
            this.moveCount++;
        }
    };

    public int getMoveCount() {
        return this.moveCount;
    }
}

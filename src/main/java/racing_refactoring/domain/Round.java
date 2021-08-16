package racing_refactoring.domain;

import racing_refactoring.strategy.CarStrategyImpl;
import racing_refactoring.strategy.CarStrategy;

public class Round {

    private final static CarStrategy CAR_STRATEGY = new CarStrategyImpl();
    private final static int FINISH_ROUND = 0;

    private int trial;

    public Round(final int trial) {
        if(CAR_STRATEGY.underMinLength(trial)){
            throw new IllegalArgumentException("경기 횟수를 입력해주세요");
        }
        this.trial = trial;
    }

    public void next(){
        trial--;
    }

    public boolean isFinished(){
        return trial == FINISH_ROUND;
    }
}

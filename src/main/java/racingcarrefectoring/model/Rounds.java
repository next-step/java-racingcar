package racingcarrefectoring.model;

import racingcarrefectoring.exception.ByZeroException;

public class Rounds {

    private final int roundCount;

    public Rounds(int roundCount){
        if(roundCount == 0){
            throw new ByZeroException("경기 수는 0을 입력할 수 없습니다");
        }
        if(roundCount < 0){
            throw new NegativeArraySizeException("경기 수는 음수를 입력할 수 없습니다");
        }
        this.roundCount = roundCount;
    }

    public void play(Cars cars){
        for (int i = 0; i < roundCount; i++) {
            Round.play(cars);
        }
    }
}
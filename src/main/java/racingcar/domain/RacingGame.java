package racingcar.domain;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.EachRound;
import racingcar.dto.FinalResult;
import racingcar.dto.InputManagement;

import java.util.Map;

public class RacingGame {

    private Cars carGroup;
    private FinalResult finalResult = new FinalResult();
    private int thisRound = 0;

    public Map<Integer, Map<String, Integer>> getFinalResult() {
        return finalResult.getFinalResult();
    }

    public void recordEachRoundPosition() {
        EachRound eachRound = new EachRound();

        for (Car car : carGroup.getCars()) {
            eachRound.recordRoundPosition(car);
        }

        finalResult.recordRoundPosition(thisRound, eachRound.getResult());
    }

    public void playRacing() {
        carGroup.updateEveryCarByCondition();

        recordEachRoundPosition();
    }

    public boolean hasNextRound() {
        return InputManagement.getCountRound() > thisRound++;
    }

    public Map<Integer, Map<String, Integer>> startRacing(Cars carGroup) {
        this.carGroup = carGroup;

        while (hasNextRound()) {
            playRacing();
        }

        return finalResult.getFinalResult();
    }
}

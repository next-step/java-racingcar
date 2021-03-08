package racingcar;

import racingcar.dto.EachRound;
import racingcar.dto.FinalResult;
import racingcar.dto.InputManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGame {

    private Cars carGroup;
    private FinalResult finalResult = new FinalResult();
    private int thisRound = 0;

    public void playRacing() {
        EachRound eachRound = new EachRound();

        carGroup.updateEveryCarByCondition();

        for (Car car : carGroup.getCars()) {
            eachRound.recordRoundPosition(car);
        }

        finalResult.recordRoundPosition(thisRound, eachRound.getResult());
        thisRound++;
    }

    public boolean hasNextRound() {
        return InputManagement.getCountRound() > thisRound;
    }

    public Map<Integer, Map<String, Integer>> startRacing(Cars carGroup) {
        this.carGroup = carGroup;

        while (hasNextRound()) {
            playRacing();
        }

        return finalResult.getFinalResult();
    }
}

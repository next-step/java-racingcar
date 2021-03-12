package racingcar.domain;

import racingcar.dto.EachRound;
import racingcar.dto.InputManagement;

public class RacingGame {

    private Cars carGroup;
    private FinalResult finalResult = new FinalResult();
    private int thisRound = 1;

    public Cars getWinners() {
        return finalResult.getWinnersInCars();
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

    public boolean hasNextRound(InputManagement inputManagement) {
        return inputManagement.getCountRound() >= thisRound++;
    }

    public FinalResult startRacing(InputManagement inputManagement) {
        while (hasNextRound(inputManagement)) {
            playRacing();
        }

        return finalResult;
    }

    public void init(Cars carGroup) {
        this.carGroup = carGroup;
    }
}

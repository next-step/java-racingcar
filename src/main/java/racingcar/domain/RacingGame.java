package racingcar.domain;

import racingcar.dto.EachRound;

public class RacingGame {

    private Cars carGroup;
    private FinalResult finalResult = new FinalResult();

    public FinalResult getFinalResult() {
        return finalResult;
    }

    public Cars getWinners() {
        return finalResult.getWinnersInCars();
    }

    public void recordEachRoundPosition(int thisRound) {
        EachRound eachRound = new EachRound();

        for (Car car : carGroup.getCars()) {
            eachRound.recordRoundPosition(car);
        }

        finalResult.recordRoundPosition(thisRound, eachRound.getResult());
    }

    public void playRacing() {
        carGroup.updateEveryCarByCondition();
    }

    public void init(Cars carGroup) {
        this.carGroup = carGroup;
    }
}

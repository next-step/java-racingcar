package study.racingcar.controller;

import study.racingcar.domain.CarGenerator;
import study.racingcar.domain.Cars;
import study.racingcar.domain.RandomMovingStrategy;
import study.racingcar.dto.RacingResult;
import study.racingcar.dto.WinnerResults;

public class RacingContest {

    private Cars cars;
    private final int tryNo;
    private int currentTry;

    public RacingContest(String racingParticipantByName, int tryNo) {
        cars = new Cars(CarGenerator.generateByString(racingParticipantByName));
        this.tryNo = tryNo;
        this.currentTry = 0;
    }

    public RacingResult gerResult() {
        return new RacingResult(cars.getResult());
    }

    public boolean isPlaying() {
        return currentTry < tryNo;
    }

    public void play() {
        cars.moveAll(new RandomMovingStrategy());
        currentTry++;
    }

    public WinnerResults findWinners() {
        return new WinnerResults(cars.findWinners());
    }
}

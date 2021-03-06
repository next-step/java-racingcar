package racingcar.domain;

import racingcar.dto.RacingCarGameRequest;
import racingcar.dto.FinalScoreBoard;
import racingcar.dto.ScoreBoardPerPlay;

import java.util.Arrays;

public class RacingCarGame {

    private final RacingCarList participatingRacingCarList;

    private int playCount;

    private int currentCount;

    private FinalScoreBoard finalScoreBoard;

    public RacingCarGame(RacingCarGameRule racingCarGameRule, RacingCarGameRequest userInput) {
        playCount = userInput.getPlayCount();
        participatingRacingCarList = new RacingCarList();
        finalScoreBoard = new FinalScoreBoard();
        enrollParticipatingCar(racingCarGameRule, userInput.getCarNameArray());
    }

    private void enrollParticipatingCar(RacingCarGameRule racingCarGameRule, String[] carNameArray) {
        participatingRacingCarList.addBulk(racingCarGameRule, carNameArray);
    }

    public boolean isDone() {
        return currentCount >= playCount;
    }

    public void play() {
        if (isDone()) {
            throw new IllegalStateException("game is over");
        }
        participatingRacingCarList.move();
        currentCount++;
        finalScoreBoard.add(currentCount, participatingRacingCarList.getIndividualScore());
    }

    public FinalScoreBoard getFinalScoreBoard() {
        return finalScoreBoard;
    }
}

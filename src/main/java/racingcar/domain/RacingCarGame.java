package racingcar.domain;

import racingcar.dto.RacingCarGameRequest;
import racingcar.dto.FinalScoreBoard;
import racingcar.dto.ScoreBoardPerPlay;

public class RacingCarGame {

    private RacingCarList participatingRacingCarList;

    private int playCount;

    private int currentCount;

    private FinalScoreBoard finalScoreBoard;

    public RacingCarGame(RacingCarGameRequest userInput) {
        playCount = userInput.getPlayCount();
        participatingRacingCarList = new RacingCarList(userInput.getCarNumber());
        finalScoreBoard = new FinalScoreBoard();
    }

    public boolean isDone(){
        return currentCount >= playCount;
    }

    public void play() {
        if(isDone()) {
            throw new IllegalStateException("game is over");
        }
        participatingRacingCarList.move();
        currentCount++;
        finalScoreBoard.add(currentCount,participatingRacingCarList.getIndividualScore());
    }

    public FinalScoreBoard getFinalScoreBoard() {
        return finalScoreBoard;
    }
}

package step03;

import java.util.List;

public class RacingCarRound {
    private static final int RACING_ROUND_COUNT_INIT = 0;
    private int totalRacingRoundCount;
    private int currentRacingRoundCount;


    RacingCarRound(int tryCount) {
        totalRacingRoundCount = tryCount;
        currentRacingRoundCount = RACING_ROUND_COUNT_INIT;
    }

    public boolean isFinishRound() {
        if (totalRacingRoundCount > currentRacingRoundCount) {
            currentRacingRoundCount++;
            return false;
        }
        return true;
    }

    public void showRacingRoundResult(List<RacingCar> racingCars) {
        ResultView.showRacingResult(racingCars);
    }

    public void showRacingRoundFinalWinner(RacingCar winner) {
        ResultView.showRacingWinner(winner.getRacingCarData().getCarName());
    }

}

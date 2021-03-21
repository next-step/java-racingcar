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


    public void showRacingRoundFinalWinner(List<RacingCar> winners) {
        StringBuilder winnersName = new StringBuilder();
        for (RacingCar racingCar : winners) {
            addDelimiter(winnersName);
            winnersName.append(racingCar.getRacingCarData().getCarName());
        }
        ResultView.showRacingWinner(winnersName.toString());
    }

    private StringBuilder addDelimiter(StringBuilder winnerName) {
        if (winnerName.length() > 0) {
            winnerName.append(",");
        }
        return winnerName;
    }

}

package racing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameResult {
    private List<RacingGameRoundResult> racingGameRoundResult;
    private int time;

    public RacingGameResult(List<RacingGameRoundResult> racingGameRoundResult, int time) {
        this.racingGameRoundResult = racingGameRoundResult;
        this.time = time;
    }

    public int getTime() {
        return this.time;
    }

    public List<RacingGameRoundResult> printRoundHistory() {
        return this.racingGameRoundResult;
    }

    // 우승자 반환
    public List<String> findRacingWinner() {
        int lastRound = racingGameRoundResult.size() - 1;
        RacingGameRoundResult lastRoundResult = racingGameRoundResult.get(lastRound);

        List<CarRoundResult> carRoundResults = lastRoundResult.getCarResults();
        Collections.sort(carRoundResults);

        int winnerMovePosition = carRoundResults.get(carRoundResults.size() - 1).getMovePosition();
        List<String> winners = new ArrayList<String>();

        for (CarRoundResult carRoundResult : carRoundResults) {
            if (carRoundResult.getMovePosition() == winnerMovePosition) {
                winners.add(carRoundResult.getCarName());
            }
        }

        return winners;
    }
}

package car.entity;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private static final String WIN = "WIN";
    private static final String LOSE = "LOSE";
    private static final String SAME = "DRAW";

    private List<Car> aRoundResult;
    private List<Car> winners;
    private int maxMovement;

    public static GameResult createResultInstance(List<Car> result) {
        GameResult gameResult = new GameResult();
        gameResult.aRoundResult = result;
        gameResult.maxMovement = 0;
        gameResult.winners = new ArrayList<>();
        return gameResult;
    }

    public List<Car> getRoundResult() {
        return aRoundResult;
    }

    public List<Car> getGameWinner() {
        for(Car aCar : aRoundResult) {
            judgeWhoisWinner(aCar, maxMovement);
        }
        return winners;
    }

    public void judgeWhoisWinner(Car car, int maxCount) {
        CarJudgeStatus judgeResult = car.judgeMaxMovement(maxCount);

        if ( CarJudgeStatus.LOSE == judgeResult ) {
            return;
        }

        if ( CarJudgeStatus.DRAW == judgeResult ) {
            winners.add(Car.getCarInstance(car.name));
            return;
        }

        if ( CarJudgeStatus.WIN == judgeResult ) {
            winners.clear();
            maxMovement = car.movingCount;
            winners.add(Car.getCarInstance(car.name));
        }
    }
}

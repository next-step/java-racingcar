package car.entity;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private List<Car> aRoundResult;
    private List<Car> winners;

    public GameResult() {
        aRoundResult = new ArrayList<>();
        winners = new ArrayList<>();
    }

    public static GameResult createResultInstance(List<Car> result) {
        GameResult gameResult = new GameResult();
        gameResult.aRoundResult = result;
        return gameResult;
    }

    public List<Car> getRoundResult() {
        return aRoundResult;
    }


    public List<Car> getWinnerNames() {
        int maxMovement = 0;

        for(Car car : aRoundResult) {
            maxMovement = getWhoIsWinner(car, maxMovement);
        }

        return winners;
    }

    private int getWhoIsWinner (Car car, int maxMovement) {
        CarJudgeStatus judgeResult = car.judgeMaxMovement(maxMovement);
        if ( CarJudgeStatus.LOSE == judgeResult ) {
            return maxMovement;
        }

        setWinnerNames(car, judgeResult );
        return car.getMovingCount();
    }

    private void setWinnerNames(Car car, CarJudgeStatus status) {
        if (CarJudgeStatus.DRAW == status) {
            winners.add(Car.getCarInstance(car.getName()));
            return;
        }

        if (CarJudgeStatus.WIN == status) {
            winners.clear();
            winners.add(Car.getCarInstance(car.getName()));
        }
    }
}

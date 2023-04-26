package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private MoveStrategy moveStrategy = new FourOverTenMoveStrategy();

    public ScoreBoard play(List<String> carNames, int trialNumber){
        CarCollection cars = new CarCollection(carNames, moveStrategy);

        List<Result> results = tryMoves(cars, trialNumber);
        List<String> winners = cars.getFrontRunnerNames();

        return new ScoreBoard(results, winners);
    }

    private List<Result> tryMoves(CarCollection cars, int trialNumber) {
        List<Result> results = new ArrayList<>();

        for (int i = 0; i< trialNumber; i++) {
            cars.tryMove();
            results.add(new Result(cars.getCarScores()));
        }

        return results;
    }
}

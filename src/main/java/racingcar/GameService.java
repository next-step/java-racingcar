package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private List<String> carNames;
    private int trialNumber;
    private MoveStrategy moveStrategy = new FourOverTenMoveStrategy();

    public GameService(List<String> carNames, int trialNumber) {
        this.carNames = carNames;
        this.trialNumber = trialNumber;
    }

    public List<Result> play(){
        CarCollection cars = new CarCollection(carNames, moveStrategy);
        List<Result> results = tryMoves(cars, this.trialNumber);
        return results;
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

package racingGame.Business;

import java.util.ArrayList;
import java.util.List;
import racingGame.Response.GameResult;
import racingGame.model.Car;
import racingGame.model.ProgressRecord;
import racingGame.util.RandomUtil;

public class Process {
    
    private List<Car> joinCars;
    private final List<ProgressRecord> progressRecords = new ArrayList<>();

    public List<GameResult> run(int cars, int moves) {
        this.joinCars = new CarFactory().createCars(cars);
        this.joinCars
                .addAll(new GameMove(moves).
                        moveCar(this.joinCars));

        return showResult();
    }

    private List<GameResult> showResult() {
        List<GameResult> gameResults = new ArrayList<>();
        gameResults.add(new GameResult(this.progressRecords));
        return gameResults;
    }


    
    public List<Car> joinCars() {
        return this.joinCars;
    }
}
package racingGame.business;

import racingGame.response.GameFinalResult;
import racingGame.response.GameResult;
import racingGame.model.Car;
import racingGame.model.ProgressRecord;
import racingGame.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class GameMove {

    private int moves;

    public GameMove(int moves) {
        validate(moves);
        this.moves = moves;
    }

    public GameFinalResult moveCar(List<Car> joinCars) {
        List<ProgressRecord> progressRecords = new ArrayList<>();
        for (int i = 0; i < this.moves; i++) {
            progressRecords.add(new ProgressRecord(joinCars));
            nextMove(joinCars);
        }
        
        List<GameResult> gameResults = new ArrayList<>();
        gameResults.add(new GameResult(progressRecords));
        
        return new GameFinalResult(gameResults, progressRecords.getLast().findWinners());
    }

    private void nextMove(List<Car> joinCars) {
        for(Car car: joinCars) {
            car.forward(RandomUtil.generateInt());
        }
    }

    private void validate(int moves) {
        if(moves < 1) {
            throw new IllegalArgumentException("이동횟수에 입력이 생략되거나, 0이하");
        }
    }

}

package racingGame.business;

import racingGame.model.GameResult;
import racingGame.model.Car;
import racingGame.model.NonNegativeMoves;
import racingGame.model.ProgressRecord;
import racingGame.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public record GameMove(NonNegativeMoves moves) {
    
    public GameResult moveCar(List<Car> joinCars) {
        List<ProgressRecord> progressRecords = new ArrayList<>();
        for(int i = 0; i < this.moves.getMoves(); i++) {
            nextMove(joinCars);
            progressRecords.add(new ProgressRecord(joinCars));
        }
        return new GameResult(progressRecords);
    }
    
    private void nextMove(List<Car> joinCars) {
        for(Car car: joinCars) {
            car.forward(RandomUtil.generateInt());
        }
    }
    
}

package racingGame.business;

import racingGame.model.GameResult;
import racingGame.model.Car;
import racingGame.model.ProgressRecord;
import racingGame.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public record GameMove(int moves) {
    
    public GameMove {
        validate(moves);
    }
    
    public GameResult moveCar(List<Car> joinCars) {
        List<ProgressRecord> progressRecords = new ArrayList<>();
        for(int i = 0; i < this.moves; i++) {
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
    
    private void validate(int moves) {
        if(moves < 1) {
            throw new IllegalArgumentException("이동횟수에 입력이 생략되거나, 0이하");
        }
    }
    
}

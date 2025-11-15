package racingGame.business;

import racingGame.model.*;
import racingGame.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public record GameMove(NonNegativeMoves moves) {
    
    public GameResult moveCar(JoinCars joinCars) {
        List<ProgressRecord> progressRecords = new ArrayList<>();
        for(int i = 0; i < this.moves.getMoves(); i++) {
            nextMove(joinCars);
            progressRecords.add(new ProgressRecord(joinCars));
        }
        return new GameResult(progressRecords);
    }
    
    private void nextMove(JoinCars joinCars) {
        for(Car car: joinCars.cars()) {
            car.forward(RandomUtil.generateInt());
        }
    }
    
}

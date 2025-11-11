package racingGame.Business;

import racingGame.Response.GameFinalResult;
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
            progressRecords.add(recordCarsMove(joinCars));
            nextMove(joinCars);
        }
        return new GameFinalResult(progressRecords, findWinners(progressRecords.getLast()));
    }

    private List<String> findWinners(ProgressRecord progressRecords) {
        for (int i = 0; i < progressRecords.carRecord().size(); i++) {


        }

        return null;

    }

    private void nextMove(List<Car> joinCars) {
        for(Car car: joinCars) {
            car.forward(RandomUtil.generateInt());
        }
    }

    private ProgressRecord recordCarsMove(List<Car> joinCars) {
        ProgressRecord pr = new ProgressRecord();
        pr.recordGame(joinCars);
        return pr;
    }

    private void validate(int moves) {
        if(moves < 1) {
            throw new IllegalArgumentException("이동횟수에 입력이 생략되거나, 0이하");
        }
    }

}

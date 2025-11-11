package racingGame.Business;

import racingGame.model.Car;
import racingGame.model.ProgressRecord;
import racingGame.util.RandomUtil;

import java.util.List;

public class GameMove {

    private int moves;

    public GameMove(int moves) {
        validate(moves);
        this.moves = moves;
    }

    public List<Car> moveCar(List<Car> joinCars) {
        List<Car> cars = null;
        for (int i = 0; i < this.moves; i++) {
            cars = nextMove(joinCars);
        }
        return cars;
    }

    private List<Car> nextMove(List<Car> joinCars) {
        for(Car car: joinCars) {
            car.forward(RandomUtil.generateInt());
        }
        return joinCars;
    }

//    private void recordCarsMove() {
//        ProgressRecord pr = new ProgressRecord();
//        pr.recordGame(this.joinCars);
//        progressRecords.add(pr);
//    }

    private void validate(int moves) {
        if(moves < 1) {
            throw new IllegalArgumentException("이동횟수에 입력이 생략되거나, 0이하");
        }
    }

}

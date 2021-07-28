package step5.domain.strategy;

import step5.common.RandomFactory;
import step5.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberMoveStrategy implements MoveStrategy {
    private final int MOVE_BOUNDARY;
    private final int RANDOM_BOUNDARY;

    public RandomNumberMoveStrategy(int MOVE_BOUNDARY, int RANDOM_BOUNDARY) {
        this.MOVE_BOUNDARY = MOVE_BOUNDARY;
        this.RANDOM_BOUNDARY = RANDOM_BOUNDARY;
    }

    @Override
    public boolean isMove(int randomNumber) {
        if (randomNumber >= MOVE_BOUNDARY) {
            return true;
        }
        return false;
    }

    @Override
    public List move(List<Car> carList) {
        for (Car car : carList) {
            car.move(isMove(RandomFactory.getRandomNumber(RANDOM_BOUNDARY)));
        }
        return new ArrayList<>(carList);
    }


}

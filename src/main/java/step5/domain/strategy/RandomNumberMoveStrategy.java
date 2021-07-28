package step5.domain.strategy;

import step5.common.RandomFactory;
import step5.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberMoveStrategy implements MoveStrategy {
    private final int MOVE_BOUNDARY = 4;

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
            car.move(isMove(RandomFactory.getRandomNumber()));
        }
        return new ArrayList<>(carList);
    }
}

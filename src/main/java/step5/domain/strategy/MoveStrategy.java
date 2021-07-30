package step5.domain.strategy;

import step5.domain.Car;

import java.util.List;

public interface MoveStrategy {
    boolean isMove(int randomNumber);

    List<Car> move(List<Car> carList);
}

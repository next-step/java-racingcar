package step5.domain.strategy;

import step5.domain.Car;

import java.util.List;

public interface WinnerStrategy {
    List<Car> getWinner(List<Car> carList);
}

package step3.worker.domain.strategy;

import step3.worker.domain.Car;

import java.util.List;

public interface SelectWinnerStrategy {
    List<Car> select(final List<Car> cars);
}

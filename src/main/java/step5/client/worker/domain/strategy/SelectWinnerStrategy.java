package step5.client.worker.domain.strategy;

import step5.client.worker.domain.Car;

import java.util.List;

public interface SelectWinnerStrategy {
    List<Car> select(final List<Car> cars);
}

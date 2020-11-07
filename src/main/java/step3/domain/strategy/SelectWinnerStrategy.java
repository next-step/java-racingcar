package step3.domain.strategy;

import step3.domain.Car;

import java.util.List;

public interface SelectWinnerStrategy {
    List<Car> select(final List<Car> cars);
}

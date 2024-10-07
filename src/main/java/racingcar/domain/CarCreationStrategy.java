package racingcar.domain;

import java.util.List;

@FunctionalInterface
public interface CarCreationStrategy {
    List<Car> create(String names);
}

package racingcar.view;

import java.util.List;

import racingcar.domain.Distance;

@FunctionalInterface
public interface Display {
    void show(List<Distance> distances);
}

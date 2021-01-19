package racingcar;

import java.util.List;

public interface CarFactory {
    List<Car> makeCars(String[] names);
}
package racingcar.utils;

import racingcar.domain.Car;

import java.util.List;

public interface RankPicker {
    List<Car> pickTopRankers(List<Car> cars);
}
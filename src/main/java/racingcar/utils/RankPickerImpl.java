package racingcar.utils;

import racingcar.domain.Car;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RankPickerImpl implements RankPicker {
    @Override
    public List<Car> pickTopRankers(List<Car> cars) {
        // Collections 활용 로직처리를 어떻게 해야할까, 고민하다가 스트림 사용
        return Stream
                .of(Collections.max(cars, Comparator.comparingInt(Car::getPosition)))
                .flatMap(topRanker -> cars.stream().filter(car -> topRanker.getPosition() == car.getPosition()))
                .collect(Collectors.toList());
    }
}
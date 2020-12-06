package step4.domain.judge;

import step4.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class LongPositionJudge implements Judge<String, List<Car>> {

    @Override
    public String judge(List<Car> cars) {
        int longDistance = cars.stream()
                                .map(car -> car.getPosition())
                                .max(Integer::compareTo).get();

        return cars.stream()
                .filter(car -> car.getPosition() == longDistance)
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
    }
}

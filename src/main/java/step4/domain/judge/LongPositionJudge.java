package step4.domain.judge;

import step4.domain.Car;

import java.util.List;

public class LongPositionJudge implements Judge<Integer, List<Car>> {

    @Override
    public Integer judge(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getPosition())
                .max(Integer::compareTo).get();
    }

}

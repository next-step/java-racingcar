package racingcar.utils;

import racingcar.domain.Car;
import java.util.ArrayList;
import java.util.List;

public class RankPickerImpl implements RankPicker {
    @Override
    public List<Car> pickTopRankers(List<Car> cars) {
        List<Car> topRankers = new ArrayList<>();
        cars.sort((car1, car2) -> car2.getPosition() - car1.getPosition());
        Car topRanker = cars.get(0);
        int positionOfTopRanker = topRanker.getPosition();
        for (Car car : cars) {
            if (positionOfTopRanker == car.getPosition()) {
                topRankers.add(car);
            }
        }
        return topRankers;
    }
}
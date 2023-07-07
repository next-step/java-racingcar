package car.domain;

import car.domain.winnerstrategy.WinnerStrategy;
import utils.random.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> list;

    public Cars(final List<String> names) {
        list = names.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public void move(RandomGenerator randomGenerator) {
        for (Car car : list) {
            car.move(randomGenerator.extractRandomSingleDigit());
        }
    }

    List<Car> getList() {
        return list;
    }

    public List<String> format(final CarFormatter formatter) {
        return list.stream()
                .map(formatter::format)
                .collect(Collectors.toList());
    }

    public List<Car> selectWinners(final WinnerStrategy winnerStrategy) {
        return winnerStrategy.selectWinners(list);
    }
}

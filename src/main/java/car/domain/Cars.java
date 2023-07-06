package car.domain;

import car.domain.winnerstrategy.WinnerStrategy;
import car.ui.CarFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.random.RandomGenerator;

public class Cars {

    private final List<Car> list;

    public Cars(String names) {
        list = Arrays.stream(split(names))
            .map(Car::new)
            .collect(Collectors.toUnmodifiableList());
    }

    private String[] split(final String names) {
        return names.split(",");
    }


    public void move() {
        for (Car car : list) {
            car.move(RandomGenerator.extractRandomSingleDigit());
        }
    }

    public void print(final CarFormatter formatter) {
        list.forEach(car -> System.out.println(formatter.format(car)));
        System.out.println();
    }

    public List<Car> getWinners(final WinnerStrategy winnerStrategy) {
        return winnerStrategy.getWinners(list);
    }
}

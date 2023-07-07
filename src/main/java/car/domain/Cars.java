package car.domain;

import car.domain.winnerstrategy.WinnerStrategy;
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


    public void move(RandomGenerator randomGenerator) {
        for (Car car : list) {
            car.move(randomGenerator.extractRandomSingleDigit());
        }
    }

    List<Car> getList() {
        return list;
    }

    public void print(final CarsFormatter formatter) {
        System.out.println(formatter.format(list));
    }

    public List<Car> getWinners(final WinnerStrategy winnerStrategy) {
        return winnerStrategy.selectWinners(list);
    }
}

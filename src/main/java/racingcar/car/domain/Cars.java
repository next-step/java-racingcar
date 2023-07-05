package racingcar.car.domain;

import racingcar.car.domain.winnerstrategy.WinnerStrategy;
import racingcar.car.ui.CarFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.random.RandomGenerator;

public class Cars {

    private List<Car> list;

    public Cars(String names) {
        list = Arrays.stream(split(names))
            .map(Car::new)
            .collect(Collectors.toList());
    }

    private String[] split(String names) {
        return names.split(",");
    }


    public void move() {
        for (Car car : list) {
            car.move(RandomGenerator.extractRandomSingleDigit());
        }
    }

    public void print(CarFormatter formatter) {
        list.forEach(car -> System.out.println(formatter.format(car)));
        System.out.println();
    }

    public List<Car> getWinners(WinnerStrategy winnerStrategy) {
        return winnerStrategy.getWinners(list);
    }
}

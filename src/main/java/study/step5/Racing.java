package study.step5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import study.step5.domain.Car;
import study.step5.domain.RandomMovingStrategy;

/**
 * Racing Game Class
 *
 * 자동차 경주 클래스
 *
 */
public class Racing {
    private List<Car> carList;
    private RacingWinner racingWinner;

    public Racing() {
        carList = new ArrayList<>();
        racingWinner = new RacingWinner();
    }

    public void setUp(String[] names) {
        IntStream.range(0, names.length).forEach(i -> carList.add(new Car(names[i])));
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void run() {
        carList.forEach(car -> car.move(new RandomMovingStrategy()));
    }

    public List<String> getWinners() {
        racingWinner.determineWinners(carList);
        return racingWinner.getWinnerNames();
    }
}

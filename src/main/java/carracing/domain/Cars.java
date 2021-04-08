package carracing.domain;

import carracing.util.RandomUtil;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        saveCarNames(carNames);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private void saveCarNames(String carNames) {
        if ("".equals(carNames.trim()))
            throw new IllegalArgumentException("자동차 이름을 입력해주세요.");

        String[] names = carNames.split(",");
        Arrays.stream(names).forEach(name -> this.cars.add(new Car(name)));
    }

    public void play() {
        cars.stream().forEach(car -> car.move(RandomUtil.randomNumber()));
    }

    public String getWinners() {
        return getWinnerNames(getMaxScore());
    }

    private String getWinnerNames(int maxScore) {
        List<Car> winners = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.isWinner(maxScore))
                winners.add(car);
        }

        return winners.stream().map(x -> x.getName().getName()).collect(Collectors.joining(", "));
    }

    private int getMaxScore() {
        Car maxScoreCar = this.cars.stream().max(Comparator.comparingInt(Car::getPosition)).get();
        return maxScoreCar.getPosition();
    }
}

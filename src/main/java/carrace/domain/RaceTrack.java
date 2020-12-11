package carrace.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RaceTrack {
    private final List<Car> carList = new ArrayList<>();
    private final RacingRule racingRule;

    public RaceTrack(RacingRule racingRule, int carCount) {
        this.racingRule = racingRule;
        this.carList.addAll(CarFactory.makeCarList(carCount));
    }

    public RaceTrack(RacingRule racingRule, List<CarName> carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException();
        }
        this.racingRule = racingRule;
        this.carList.addAll(CarFactory.makeCarList(carNames));
    }

    public RaceTrack(RacingRule racingRule, Car... cars) {
        this.racingRule = racingRule;
        carList.addAll(Arrays.asList(cars));
    }

    public void next() {
        for (Car car : carList) {
            car.tryToMoveForward(racingRule);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinner() {
        int max = carList.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElseThrow(IllegalStateException::new);

        return carList.stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());
    }

    public String getRacingResult() {
        StringBuilder result = new StringBuilder();
        for (Car car : carList) {
            result.append(car.getRacingResult()).append(System.lineSeparator());
        }
        return result.toString();
    }

    public String getWinnerResult() {
        List<Car> winners = this.getWinner();
        StringBuilder result = new StringBuilder();
        StringJoiner carNameJoiner = new StringJoiner(", ");
        for (Car winner : winners) {
            String name = winner.getName();
            carNameJoiner.add(name);
        }
        result.append(carNameJoiner);
        result.append("가 최종 우승했습니다.");

        return result.toString();
    }

}

package dev.djoon.racingcar.domain;

import dev.djoon.racingcar.domain.util.GameConstant;
import dev.djoon.racingcar.domain.util.RandomNumbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

  private final List<Car> carList;
  private final RandomNumbers randomNumbers;

  public RacingCarGame(int carQuantity, RandomNumbers randomNumbers) {
    this.carList = fillCarList(carQuantity);
    this.randomNumbers = randomNumbers;
  }

  public RacingCarGame(List<String> ownerNames, RandomNumbers randomNumbers) {
    this.carList = fillCarList(ownerNames);
    this.randomNumbers = randomNumbers;
  }

  public void start() {
    carsMoveIfValid(randomNumbers);
  }

  public List<Car> getCarList() {
    return carList;
  }

  public List<Car> findWinners() {
    final int winnerScore = findWinnerScore();

    return carList.stream()
                  .filter(car -> car.getXPosition() == winnerScore)
                  .collect(Collectors.toList());
  }

  private int findWinnerScore() {
    return carList.stream()
                  .max(Comparator.comparingInt(Car::getXPosition))
                  .map(Car::getXPosition).orElse(0);
  }

  private void carsMoveIfValid(RandomNumbers random) {
    for (Car car : carList) {
      int randomValue = random.nextInt(GameConstant.RANDOM_BOUNDARY);
      car.moveIfValidCondition(randomValue);
    }
  }

  private List<Car> fillCarList(int carQuantity) {
    List<Car> filledCarList = new ArrayList<>();

    for (int i = 0; i < carQuantity; i++) {
      filledCarList.add(RacingCarFactory.create());
    }

    return filledCarList;
  }

  private List<Car> fillCarList(List<String> ownerNames) {
    List<Car> filledCarList = new ArrayList<>();

    for (String ownerName : ownerNames) {
      filledCarList.add(RacingCarFactory.createWithOwner(ownerName));
    }

    return filledCarList;
  }

}

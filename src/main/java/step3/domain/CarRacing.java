package step3.domain;

import step3.util.RandomUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarRacing {
    private final List<Car> carList;
    private final Round round;

    public CarRacing(String[] carsName, Round round) {
        this.carList = makeRacingCars(carsName);
        this.round = round;
    }

    private List<Car> makeRacingCars(String[] carsName) {
        List<Car> racingCars = new ArrayList<>();

        for (String carName : carsName) {
            racingCars.add(new Car(carName));
        }

        return racingCars;
    }

    public List<CarRacingResult> start() {
        List<CarRacingResult> carRacingResultList = new ArrayList<>();

        while (round.isRoundContinue()) {
            moveForward();
            carRacingResultList.add(new CarRacingResult(this.carList, findWinnerCarNames()));
            round.reduceRound();
        }

        return carRacingResultList;
    }

    private void moveForward() {
        for (Car car : carList) {
            car.moveForward(RandomUtil.makeRandomNumber(), num -> num >= 4);
        }
    }

    private List<String> findWinnerCarNames() {
        return carList.stream()
                .filter(car -> car.isWinner(getMaxCurrentPosition()))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private int getMaxCurrentPosition() {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getCurrentPosition))
                .orElseThrow(NoSuchElementException::new)
                .getCurrentPosition();
    }

}

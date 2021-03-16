package step3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarRacing {
    private final List<Car> carList;
    private Round round;

    public CarRacing(String[] carsName) {
        this(carsName, null);
    }

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

    public List<CarResultDto> start() {
        List<CarResultDto> carResultDtoList = new ArrayList<>();

        while (round.isRoundContinue()) {
            moveForward();
            carResultDtoList.add(new CarResultDto(this.carList, findWinnerCarNames()));
            round.reduceRound();
        }

        return carResultDtoList;
    }

    private void moveForward() {
        for (Car car : carList) {
            car.moveForward(RandomUtil.makeRandomNumber(), num -> num >= 4);
        }
    }

    public List<String> findWinnerCarNames() {
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

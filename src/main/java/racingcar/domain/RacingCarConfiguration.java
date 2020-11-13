package racingcar.domain;

import racingcar.domain.utils.Number;
import racingcar.domain.utils.Splitter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RacingCarConfiguration {

    private List<Car> carList;
    private String[] carNames;
    private Splitter splitter;

    public RacingCarConfiguration() {
        this.splitter = new Splitter();
    }

    private void initRacingCar() {
        this.carList = Arrays.stream(carNames)
                .map(carName -> createRacingCar(carName))
                .collect(Collectors.toList());
    }

    private Car createRacingCar(String carName) {
        return new Car(carName);
    }

    public List<Car> enterCar(String carNameList) {
        this.carNames = splitter.splitNames(carNameList);
        initRacingCar();
        return this.carList;
    }

    public String findWinningCarNames() {
        Optional<Car> firstCar = this.carList.stream().max(Comparator.comparing(Car::getPlace));
        if (!firstCar.isPresent()) {
            return "";
        }
        return createWiningCarNames(findDuplicatePlaceCar(firstCar.get()));
    }

    private List<String> findDuplicatePlaceCar(Car firstCar) {
        return this.carList.stream()
                .filter(car -> isDuplicatePlace(car, firstCar))
                .map(Car::getName).collect(Collectors.toList());
    }

    private boolean isDuplicatePlace(Car car, Car firstCar) {
        return car.getPlace() == firstCar.getPlace();
    }

    private String createWiningCarNames(List<String> winingCars) {
        StringBuilder sb = new StringBuilder();

        int winingCarCount = winingCars.size();
        sb.append(winingCars.get(Number.ZERO));
        for (int index = 1; index < winingCarCount; index++) {
            sb.append(',').append(winingCars.get(index));
        }

        return sb.toString();
    }

}

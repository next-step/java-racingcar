package racingcar.car;

import racingcar.RacingGameResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {
    private static final String CAR_NAME_DELIMITER = "[,]";
    private List<Car> cars;

    public CarCollection(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public CarCollection(String carNames, Class engineClass) {
        cars = new ArrayList<>();

        for (String carName : getCarNameList(carNames)) {
            cars.add(createCar(carName, engineClass));
        }
    }

    private List<String> getCarNameList(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(CAR_NAME_DELIMITER));

        if(carNameList.size() == 0) {
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요");
        }

        return carNameList;
    }

    private Car createCar(String carName, Class<Engine> engineClass) {
        try {
            return new Car(carName, engineClass.getDeclaredConstructor().newInstance());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public String getNames() {
        List<String> carNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(", ", carNames);
    }

    public RacingGameResult getResult() {
        return new RacingGameResult(new ArrayList<>(cars));
    }

    public List<Integer> getRecordOfCar(int index) {
        return cars.get(index).getRecord();
    }

    public CarCollection isWin(int max) {
        List<Car> winners = cars.stream()
                .filter(car -> car.isWin(max))
                .collect(Collectors.toList());
        return new CarCollection(winners);
    }
}

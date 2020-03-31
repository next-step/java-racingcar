package racingcar.car;

import racingcar.RacingGameResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarCollection {
    private List<Car> cars;

    public CarCollection(String carNames, Class engineClass) {
        cars = new ArrayList<>();
        List<String> carNameList = getCarNameList(carNames);
        for (int i = 0; i < carNameList.size(); i++) {
            cars.add(createCar(carNameList.get(i), engineClass));
        }
    }

    private List<String> getCarNameList(String carNames) {
        List<String> carNameList = Arrays.asList(carNames.split(","));

        if(carNameList.size() == 0) {
            throw new RuntimeException("자동차 이름을 입력해 주세요");
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

    public RacingGameResult getResult() {
        List<Car> result = cars.stream()
                .map(car -> new Car(car.getName(), car.getRecord()))
                .collect(Collectors.toList());
        return new RacingGameResult(result);
    }
}

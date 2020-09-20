package racing.domain;


import racing.message.ExceptionMessage;
import racing.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    public List<Car> cars;

    public Cars(){}

    public Cars(String carNames) {
        this.cars = initCars(carNames);
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> initCars(String carNames) {
        if (ValidationUtils.isBlank(carNames)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_EXIST_CAR_NAME.getMessage());
        }

        String[] names = carNames.split(",");
        cars = new ArrayList<>();
        for (String name : names) {
            if (!ValidationUtils.validName(name)) {
                throw new IllegalArgumentException(ExceptionMessage.CANNOT_EXCEED_5_CHARACTERS.getMessage());
            }
            cars.add(new Car(name));
        }
        return cars;
    }

    public void runCars() {
        for (Car car : cars) {
            car.run(car.getRandomNumber());
        }
    }

    public List<Car> findWinners() {
        int max = getMaxPosition(this.getCars());
        return this.getCars().stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo).orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }

}

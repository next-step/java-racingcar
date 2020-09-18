package racing.domain;


import racing.message.ExceptionMessage;
import racing.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public List<Car> cars;

    public Cars(String carNames) {
        this.cars = initCars(carNames);
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

    public List<Car> getCars() {
        return cars;
    }

}

package racing.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCars {
    private static final String DELIMITER = ",";
    private final List<Car> cars;

    public RacingCars(String inputName) {
        this.cars = prepareCars(inputName);
    }

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> prepareCars(String inputName) {
        List<Car> cars = new ArrayList<>();

        checkInputName(inputName);

        String[] carNames = inputName.split(DELIMITER);

        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i]));
        }
        return cars;
    }

    private void checkInputName(String inputName) {
        if (Objects.isNull(inputName) || inputName.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 비어있습니다. 이름을 입력해주세요.");
        }
    }

    public RacingCars moveCars(CarMoveBehavior carMoveBehavior) {
        List<Car> executedCars = new ArrayList<>();
        for (Car car : cars) {
            executedCars.add(car.move(carMoveBehavior));
        }
        return new RacingCars(executedCars);
    }

    public List<Car> getCars() {
        return cars;
    }
}

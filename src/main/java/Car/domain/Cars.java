package Car.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private final int MIN_CAR_COUNT = 0;

    private List<Car> cars;

    public Cars(String[] carNames) {
        validateCarsSize(carNames);
        cars = Arrays.stream(carNames)
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public Cars(String[] carNames, MovingStrategy movingStrategy) {
        validateCarsSize(carNames);
        cars = Arrays.stream(carNames)
                .map(carName -> new Car(carName, movingStrategy))
                .collect(Collectors.toList());
    }

    private void validateCarsSize(String[] carNames) {
        if (carNames.length <= MIN_CAR_COUNT) {
            throw new IllegalArgumentException(MIN_CAR_COUNT + "보다 큰 값을 입력해주세요.");
        }
    }

    public int getCarsSize(){
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }


    public List<Car> getWinner() {
        int maxMoveCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .collect(Collectors.toList());
    }

    public void move(List<Integer> inputList) {
        int carsSize = cars.size();

        if (inputList.size() != carsSize) {
            throw new IllegalArgumentException("자동차의 갯수와 입력값이 일치하지 않습니다.");
        }

        for (int i = 0; i < carsSize; i++) {
            cars.get(i).move(inputList.get(i));
        }
    }
}

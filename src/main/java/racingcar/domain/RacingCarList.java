package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarList {
    private final List<Car> racingCarList;
    private final static int DEFAULT_POSITION = 0;

    public RacingCarList (final List<Car> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public List<CarDTO> race() {
        List<CarDTO> carDTOS = new ArrayList<>();
        for (Car car : this.racingCarList) {
            car.move(new RandomStrategy());
            carDTOS.add(car.toDTO());
        }
        return carDTOS;
    }

    public int findMaxPosition() {
        int maxPosition = DEFAULT_POSITION;
        for (Car car : this.racingCarList) {
            maxPosition = car.greaterThan(maxPosition);
        }
        return maxPosition;
    }

    public List<CarDTO> findWinners() {
        return findDuplicatePositionCar(this.findMaxPosition());

    }

    private List<CarDTO> findDuplicatePositionCar(int maxPosition) {
        List<CarDTO> carDTOS = new ArrayList<>();
        for (Car car : this.racingCarList) {
            if (car.isMaxPosition(maxPosition)) {
                carDTOS.add(car.toDTO());
            }
        }
        return carDTOS;
    }
}

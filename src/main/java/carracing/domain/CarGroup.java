package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 자동차 경주를 같이하는 자동차들을 표현한 클래스
 */
public class CarGroup {
    private List<Car> cars;

    public CarGroup(CarNameGroup carNameGroup) {
        validateCars(carNameGroup);
        initiateCars(carNameGroup);
    }

    private void validateCars(CarNameGroup carNameGroup) {
        if (carNameGroup == null) {
            throw new IllegalArgumentException("자동차들을 초기화 하기 위해서는 1개 이상의 자동차 이름이 필요합니다.");
        }
    }

    private void initiateCars(CarNameGroup carNameGroup) {
        List<CarName> names = carNameGroup.getNames();
        int numberOfCars = names.size();
        cars = new ArrayList<>(numberOfCars);
        for (CarName name : names) {
            cars.add(new Car(name));
        }
    }

    public void moveCars(MovementPolicy movementPolicy) {
        cars.forEach(car -> car.move(movementPolicy));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> retrieveWinningCars() {
        int winningPosition = getWinningPositionNumber();
        return cars.stream()
                .filter(car -> car.isWon(winningPosition))
                .collect(Collectors.toList());
    }

    private int getWinningPositionNumber() {
        return cars.stream()
                .map(Car::getPosition)
                .map(CarPosition::getNumber)
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("우승한 자동차가 없습니다."));
    }
}

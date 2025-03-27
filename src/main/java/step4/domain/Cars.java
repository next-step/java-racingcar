package step4.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<RoundStatusDTO> getRoundStatusOfCars() {
        List<RoundStatusDTO> roundStatusList = new ArrayList<>();
        for (Car car : cars) {
            roundStatusList.add(RoundStatusDTO.of(car));
        }
        return roundStatusList;
    }

    public void moveAll(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<RoundStatusDTO> findWinnersStatus() {
        List<Car> winners = findWinners();

        List<RoundStatusDTO> winnerStatuses = new ArrayList<>();
        for (Car car : winners) {
            winnerStatuses.add(RoundStatusDTO.of(car));
        }
        return winnerStatuses;
    }

    public List<Car> findWinners() {
        if (cars.isEmpty()) {
            throw new IllegalStateException("차가 없습니다.");
        }

        Car maxPositionCar = cars.get(0);
        for (Car car : cars) {
            if (car.compareTo(maxPositionCar) > 0) {
                maxPositionCar = car;
            }
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.compareTo(maxPositionCar) == 0) {
                winners.add(car);
            }
        }
        return winners;
    }
}

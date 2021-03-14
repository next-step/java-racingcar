package RacingCar.service;

import RacingCar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RandomGameService implements GameService {
    private static final MoveStrategy moveStrategy = new RandomMoveStrategy();


    @Override
    public void runStep(List<Car> cars) {
        for (Car car : cars) {
            Boolean isMove = moveStrategy.getIsMove();
            car.move(isMove);
        }
    }

    @Override
    public List<Car> generateCar(int carNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
        return cars;
    }
}

package RacingCar.service;

import RacingCar.domain.Car;

import java.util.List;

public interface GameService {

    public void runStep(List<Car> car);

    public List<Car> generateCar(int carNumber);
}

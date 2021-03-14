package step3.service;

import step3.domain.Car;

import java.util.List;

public interface GameService {

    public void runStep(List<Car> car);

    public List<Car> generateCar(int carNumber);
}

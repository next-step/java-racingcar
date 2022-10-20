package refactoringracingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private List<Car> cars;
    private CarInformation carInformation = new CarInformation();

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public void raceCarGame() {
        for (int i = 0; i < cars.size(); i++) {
            int moveDistance = new MovingStrategy().moveCarUnit();
            carInformation.updateCarStatus(i, moveDistance, cars);
        }
    }

    public List<Car> determineWinner() {
        Car winner = cars.stream().max(Comparator.comparing(Car::getCarPosition)).get();
        List<Car> winnerCars = cars.stream()
                .filter(car -> car.getCarPosition() == winner.getCarPosition())
                .collect(Collectors.toList());

        return winnerCars;
    }

}

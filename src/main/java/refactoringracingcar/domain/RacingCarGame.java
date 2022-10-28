package refactoringracingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private List<Car> cars;

    public RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public void raceCarGame() {
        for (Car car : cars) {
            boolean discriminationMove = new MovingStrategy().discriminateMovement();
            int moveDistance = car.moveCarUnit(discriminationMove);
            car.move(moveDistance);
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

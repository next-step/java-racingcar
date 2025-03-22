package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingSession {

    private final List<Car> cars;
    private PlayHistory lastPlayHistory;

    private RacingSession(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingSession of(String carNames) {
        List<Car> cars = Car.createCars(carNames);
        return new RacingSession(cars);
    }

    public List<CarsAtTurn> startRacing(int turns) {
        List<CarsAtTurn> totalPositions = new ArrayList<>();
        for (int i = 0; i < turns; i++) {
            totalPositions.add(moveCars());
        }
        this.lastPlayHistory = new PlayHistory(totalPositions);
        return totalPositions;
    }

    public CarsAtTurn moveCars() {
        List<FixedCar> carsAtTurn = new ArrayList<>();
        for (Car car : cars) {
            car.move(getProgressNumber());
            carsAtTurn.add(car.toFixedCar());
        }
        return new CarsAtTurn(carsAtTurn);
    }

    public int getProgressNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public RacingResultDto getRacingResult() {
        List<String> winnerNames = this.lastPlayHistory.findWinners();
        return new RacingResultDto(this.lastPlayHistory, winnerNames);
    }
}

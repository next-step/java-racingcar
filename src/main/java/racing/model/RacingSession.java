package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingSession {

    private final List<Car> cars;
    private PlayHistory lastPlayHistory;

    private RacingSession(List<Car> cars){
        this.cars = cars;
    }

    public static RacingSession of(String carNames){
        List<Car> cars = Car.createCars(carNames);
        return new RacingSession(cars);
    }

    public List<CarPositions> startRacing(int turns){
        List<CarPositions> totalPositions = new ArrayList<>();
        for (int i = 0; i < turns; i++) {
            totalPositions.add(moveCars());
        }
        this.lastPlayHistory = new PlayHistory(totalPositions);
        return totalPositions;
    }

    public CarPositions moveCars() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.move(getProgressNumber()));
        }
        return new CarPositions(positions);
    }

    public int getProgressNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }


    public RacingResultDto getRacingResult() {
        List<String> carNames = getCarNames();
        List<String> winnerNames = this.lastPlayHistory.findWinners(carNames);

        return new RacingResultDto(carNames, this.lastPlayHistory, winnerNames);
    }

    private List<String> getCarNames(){
        List<String> carNames = new ArrayList<>();
        for (Car car : this.cars){
            carNames.add(car.getName());
        }
        return carNames;
    }
}

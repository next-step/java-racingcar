package racing.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingSession {

    public static final int MIN_PROGRESS_NUMBER = 4;

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
            totalPositions.add(moveCars(cars));
        }
        this.lastPlayHistory = new PlayHistory(totalPositions);
        return totalPositions;
    }

    public static CarPositions moveCars(List<Car> cars) {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.move(canProgress(getProgressNumber())));
        }
        return new CarPositions(positions);
    }

    public static int getProgressNumber() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static boolean canProgress(int number) {
        return number >= MIN_PROGRESS_NUMBER;
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

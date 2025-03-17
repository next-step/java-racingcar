package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingSession {

    public static final int MIN_PROGRESS_NUMBER = 4;

    private final List<Car> cars;
    private List<CarPositions> lastPlayHistory;

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
        this.lastPlayHistory = totalPositions;
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


    public static List<String> findWinners(List<String> carNames, List<CarPositions> playHistory){
        int maxPosition = findMaxPosition(playHistory);
        CarPositions lastPositions = playHistory.get(playHistory.size()-1);
        return findMaxPositionNames(carNames, lastPositions, maxPosition);
    }

    private static int findMaxPosition(List<CarPositions> playHistory){
        CarPositions lastPositions = playHistory.get(playHistory.size()-1);
        int maxPosition = 0;
        for (Integer lastPosition : lastPositions.getCarPositions()) {
            maxPosition = Math.max(maxPosition, lastPosition);
        }
        return maxPosition;
    }

    private static List<String> findMaxPositionNames(List<String> carNames, CarPositions lastPositions, int maxPosition){
        List<String> lastPositionCarNames = new ArrayList<>();
        for (int i=0; i<carNames.size(); i++) {
            insertIfMaxPosition(carNames.get(i), lastPositions.getCarPosition(i), maxPosition, lastPositionCarNames);
        }
        return lastPositionCarNames;
    }

    private static void insertIfMaxPosition(String carName, int nowPosition, int maxPosition, List<String> lastPositionCarNames){
        if (nowPosition == maxPosition) {
            lastPositionCarNames.add(carName);
        }
    }

    public RacingResultDto getRacingResult() {
        List<String> carNames = getCarNames();
        List<String> winnerNames = findWinners(carNames, this.lastPlayHistory);

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

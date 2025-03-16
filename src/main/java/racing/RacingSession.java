package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingSession {

    public static final int MIN_PROGRESS_NUMBER = 4;

    private final List<Car> cars;
    private List<List<Integer>> lastPlayHistory;

    private RacingSession(List<Car> cars){
        this.cars = cars;
    }

    public static RacingSession of(String carNames){
        List<Car> cars = Car.createCars(carNames);
        return new RacingSession(cars);
    }

    public List<List<Integer>> startRacing(int turns){
        List<List<Integer>> totalPositions = new ArrayList<>();
        for (int i = 0; i < turns; i++) {
            totalPositions.add(moveCars(cars));
        }
        this.lastPlayHistory = totalPositions;
        return totalPositions;
    }

    public static List<Integer> moveCars(List<Car> cars) {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.move(canProgress(getRandom())));
        }
        return positions;
    }

    public static int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public static boolean canProgress(int number) {
        return number >= MIN_PROGRESS_NUMBER;
    }


    public static List<String> findWinners(List<String> carNames, List<List<Integer>> playHistory){
        int maxPosition = findMaxPosition(playHistory);
        List<Integer> lastPositions = playHistory.get(playHistory.size()-1);
        return findMaxPositionNames(carNames, lastPositions, maxPosition);
    }

    private static int findMaxPosition(List<List<Integer>> playHistory){
        List<Integer> lastPositions = playHistory.get(playHistory.size()-1);
        int maxPosition = 0;
        for (Integer lastPosition : lastPositions) {
            maxPosition = Math.max(maxPosition, lastPosition);
        }
        return maxPosition;
    }

    private static List<String> findMaxPositionNames(List<String> carNames, List<Integer> lastPositions, int maxPosition){
        List<String> lastPositionCarNames = new ArrayList<>();
        for (int i=0; i<lastPositions.size(); i++) {
            insertIfMaxPosition(carNames.get(i), lastPositions.get(i), maxPosition, lastPositionCarNames);
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

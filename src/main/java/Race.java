import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

    private static final Random random = new Random();
    private final int totalRounds;
    private final List<Car> cars;
    private int currentRound = 0;

    public Race(GameSettings settings) {
        this.totalRounds = settings.getRoundCount();
        this.cars = new ArrayList<>();
        for (String carName : settings.getCarNames()) {
            this.cars.add(new Car(carName));
        }
    }

    // 테스트용 생성자
    Race(List<Car> cars, int totalRounds) {
        this.cars = new ArrayList<>(cars);
        this.totalRounds = totalRounds;
        this.currentRound = totalRounds;  // 경주가 끝난 상태로 설정
    }

    public List<CarStatus> getCarStatuses() {
        List<CarStatus> statuses = new ArrayList<>();
        for (Car car : cars) {
            statuses.add(new CarStatus(car));
        }
        return statuses;
    }

    public void runRound() {
        validateRaceInProgress();
        for (Car car : cars) {
            car.move(random.nextInt(10));
        }
        currentRound++;
    }

    public boolean isRaceInProgress() {
        return currentRound < totalRounds;
    }

    private void validateRaceInProgress() {
        if (!isRaceInProgress()) {
            throw new IllegalStateException("Race has already finished");
        }
    }

    private void validateRaceFinished() {
        if (isRaceInProgress()) {
            throw new IllegalStateException("Race is still in progress");
        }
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private boolean isWinner(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }

    private List<CarStatus> findWinnersWithPosition(int maxPosition) {
        List<CarStatus> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinnerIfQualified(winners, car, maxPosition);
        }
        return winners;
    }

    private void addWinnerIfQualified(List<CarStatus> winners, Car car, int maxPosition) {
        if (isWinner(car, maxPosition)) {
            winners.add(new CarStatus(car));
        }
    }

    public List<CarStatus> getWinners() {
        validateRaceFinished();
        int maxPosition = findMaxPosition();
        return findWinnersWithPosition(maxPosition);
    }
}

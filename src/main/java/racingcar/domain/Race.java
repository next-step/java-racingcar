package racingcar.domain;

import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Race {
    public static final int FIRST_ATTEMPT = 1;
    private final Cars cars;
    private final Attempt totalAttempts;
    private final List<RoundResult> roundResults;

    public Race(Cars cars, Attempt attempt) {
        this.cars = cars;
        this.totalAttempts = attempt;
        this.roundResults = new ArrayList<>();
    }

    public static Race create(int carNumbers, Attempt attempt) {
        Cars cars = Cars.fromNumbers(carNumbers);
        return new Race(cars, attempt);
    }

    public static Race create(String[] carNames, Attempt attempt) {
        Cars cars = Cars.fromNames(carNames);
        return new Race(cars, attempt);
    }

    public void start(MovingStrategy strategy) throws CloneNotSupportedException {
        //첫번째 Round의 경우 모든 차가 1로 이동한다고 가정
        fisrtRound();

        for (int attempt = 1; attempt < totalAttempts.getAttempt(); attempt++) {
            cars.moveAll(strategy);
            roundResults.add(new RoundResult(new Attempt(attempt + 1), new ArrayList<>(getCurrentStatus())));
        }
    }

    public void fisrtRound() throws CloneNotSupportedException {
        roundResults.add(new RoundResult(new Attempt(FIRST_ATTEMPT), new ArrayList<>(getCurrentStatus())));
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }

    public List<Car> getCurrentStatus() throws CloneNotSupportedException {
        List<Car> currentStatusCopy = new ArrayList<>();
        for (Car car : cars.getCurrentStatus()) {
            currentStatusCopy.add(car.clone()); // Car 클래스에서 clone() 메서드를 구현해야 함
        }
        return currentStatusCopy;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

}
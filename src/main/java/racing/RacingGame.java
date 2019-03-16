package racing;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class RacingGame {
    // 운행횟수
    private int time;
    // Car 컬렉션
    private List<Car> cars;
    // 운행테이블
    private List<CarRoundResult> roundHistory;

    RacingGame(final int time, List<String> carNames) {
        this.time = time;
        this.cars = new ArrayList<Car>();
        this.roundHistory = new ArrayList<CarRoundResult>();

        for (String carName : carNames) {
            Car car = new Car(carName, 1);
            cars.add(car);
            // 첫번째운항은 무조건이동
            roundHistory.add(new CarRoundResult(1, 1, car));
        }
    }

    public int getTime() {
        return this.time;
    }

    public List<Car> getList() {
        return Collections.unmodifiableList(this.cars);
    }

    public List<CarRoundResult> getRoundHistory() {
        return this.roundHistory;
    }

    public RacingGameResult racingGameResult() {
        return new RacingGameResult(roundHistory, time);
    }

    // 운행횟수
    public void runRacingGame(GameRule gameRule) {
        for (int i = 2; i <= time; i++) {
            moveCarPositionByGameRule(i, gameRule);
        }
    }

    public void moveCarPositionByGameRule(int time, GameRule gameRule) {
        for (Car car : cars) {
            if (gameRule.moveRacingGameRule()) {
                car.move();
                roundHistory.add(new CarRoundResult(time, car.getMovePosition(), car));
                continue;
            }
            roundHistory.add(new CarRoundResult(time, car.getMovePosition(), car));
        }
    }

    public List<String> winnerRacingGame() {
        Collections.sort(cars);
        List<String> winners = new ArrayList<String>();
        for (Car car : cars) {
            if (car.getMovePosition() == cars.get(cars.size() - 1).getMovePosition()) {
                winners.add(car.getCarName());
            }
        }

        return winners;
    }
}
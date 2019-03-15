package racing;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RacingGame {
    // 운행횟수
    private int time;
    // Car 컬렉션
    private List<Car> cars;
    // 운행테이블
    private Map<Integer, Map<Car, Boolean>> RoundHistory;

    RacingGame(final int time, List<String> carNames) {
        this.time = time;
        this.cars = new ArrayList<Car>();
        this.RoundHistory = new HashMap<Integer, Map<Car, Boolean>>();

        for (String car : carNames) {
            cars.add(new Car(car));
        }
    }

    public int getTime() {
        return this.time;
    }

    public List<Car> getList() {
        return Collections.unmodifiableList(this.cars);
    }

    public Map<Integer, Map<Car, Boolean>> getRoundHistory() {
        return this.RoundHistory;
    }

    public RacingGameResult racingGameResult() {
        return new RacingGameResult(RoundHistory, winnerRacingGame(), time);
    }

    // 운행횟수
    public void runRacingGame(GameRule gameRule) {
        for (int i = 1; i <= time; i++) {
            moveCarPositionByGameRule(i,gameRule);
        }
    }

    public void moveCarPositionByGameRule(int time,GameRule gameRule) {
        // 첫번쨰 운행은 이동
        if (time == 1) {
            gameRule = new CarGameRuleOnlyTrue();
        }

        Map<Car, Boolean> move = new HashMap<Car, Boolean>();
        for (Car car : cars) {
            if (gameRule.moveRacingGameRule()) {
                car.move();
                move.put(car, true);
                RoundHistory.put(time, move);
                continue;
            }

            move.put(car, false);
            RoundHistory.put(time, move);
        }
    }

    public List<String> winnerRacingGame() {
        // position 정렬
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
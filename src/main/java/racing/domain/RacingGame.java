package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.model.CarInfo;

public class RacingGame {

    private final int roundCount;

    private final List<Car> cars;

    private RacingGame(int roundCount, List<Car> cars) {
        this.roundCount = roundCount;
        this.cars = cars;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<GameResult> start() {
        List<GameResult> results = new ArrayList<>();
        for (int i = 0; i < roundCount; i++) {
            playRound(results);
        }
        return results;
    }

    private void playRound(List<GameResult> results) {
        moveCars();
        List<CarInfo> carInfoList = getCurrentCarInfoList();
        saveRoundResult(results, carInfoList);
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<CarInfo> getCurrentCarInfoList() {
        List<CarInfo> carInfoList = new ArrayList<>();
        for (Car car : cars) {
            carInfoList.add(car.getCarInfo());
        }
        return carInfoList;
    }

    private void saveRoundResult(List<GameResult> results, List<CarInfo> carInfoList) {
        results.add(GameResult.save(carInfoList));
    }

    public static RacingGame setUp(int roundCount, List<Car> cars) {
        return new RacingGame(roundCount, cars);
    }
}

package racingcar;

import racingcar.car.Cars;
import racingcar.dto.Result;
import racingcar.dto.Winner;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final String NUMBER_PATTERN = "^[0-9]+$";
    private final List<List<Result>> eachResults = new ArrayList<>();
    private final Cars cars;
    private int count;

    public RacingGame(Cars cars, String count) {
        validateCount(count);
        this.cars = cars;
        this.count = Integer.parseInt(count.trim());
    }

    public void play() {
        while (count-- > 0) {
            cars.move();
            eachResults.add(getResult());
        }
    }

    public List<List<Result>> getEachResults() {
        return eachResults;
    }

    public List<Result> getResult() {
        return cars.findAll();
    }

    public List<Winner> getWinners() {
        return cars.findWinners();
    }

    private void validateCount(String count) {
        if (!count.trim().matches(NUMBER_PATTERN)) {
            throw new RuntimeException("실행 횟수는 양수만 가능합니다");
        }
    }
}

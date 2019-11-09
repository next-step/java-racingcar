package step2.dto;

import step2.racing.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * ResultView로 넘겨주기 위한 데이터
 */

public class ResultData {

    private List<Car> cars;

    public ResultData(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> scoreByTurn(int turn) {
        List<Integer> carScores = new ArrayList<>();
        cars.forEach((car) -> {
            carScores.add(car.getScoreByTurn(turn));
        });
        return carScores;
    }

    public List<String> getWinners() {
        int max = cars.stream()
                .map(car -> car.getFinalScore())
                .max(Integer::compareTo)
                .orElse(0);

        List<String> winners = new ArrayList<>();
        cars.forEach(car -> car.addWinner(winners, max));
        return winners;
    }
}

package step2.dto;

import step2.racing.Car;
import step2.racing.Model;
import step2.racing.Winners;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ResultView로 넘겨주기 위한 데이터
 */

public class ResultData {

    private List<Car> cars;

    public ResultData(List<Car> cars) {
        this.cars = cars;
    }

    public Map<Model, Integer> modelAndScoreByRound(int round) {
        Map<Model, Integer> carScores = new LinkedHashMap<>();
        for (Car car : cars) {
            carScores.put(car.getModel(), car.checkScoreByRound(round));
        }
        return carScores;
    }

    public Winners findWinner() {
        return new Winners(cars);
    }
}

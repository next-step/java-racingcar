package step2.dto;

import step2.racing.Car;
import step2.racing.Model;
import step2.racing.Winners;

import java.util.ArrayList;
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

    public List<Integer> scoreByRound(int round) {
        List<Integer> carScores = new ArrayList<>();
        for (Car car : cars) {
            carScores.add(car.checkScoreByRound(round));
        }
        return carScores;
    }

    public Map<Model, Integer> modelAndScoreByRound(int round) {
        return Car.checkScoreByRound(cars, round);
    }

    public Winners findWinner() {
        return new Winners(Car.findWinner(cars));
    }
}

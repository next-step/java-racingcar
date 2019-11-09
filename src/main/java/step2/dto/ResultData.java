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

    public List<Integer> scoreByTurn(int turn) {
        List<Integer> carScores = new ArrayList<>();
        for (Car car : cars) {
            carScores.add(car.getScoreByTurn(turn));
        }
        return carScores;
    }

    public Map<Model, Integer> modelAndScoreByTurn(int turn) {
        return Car.scoreByTurn(cars, turn);
    }

    public Winners getWinners() {
        return new Winners(Car.winners(cars));
    }
}

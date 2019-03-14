package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private List<Car> cars;
    private List<String> resultList;

    public RacingResult(List<Car> cars) {
        this.cars = cars;
        this.resultList = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getResultList() {
        return resultList;
    }
}


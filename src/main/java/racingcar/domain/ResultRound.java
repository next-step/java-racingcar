package racingcar.domain;

import java.util.List;

public class ResultRound {
    private List<ResultCar> resultCars;

    public ResultRound(List<ResultCar> resultCars) {
        this.resultCars = resultCars;
    }

    public List<ResultCar> getResultCars() {
        return resultCars;
    }
}

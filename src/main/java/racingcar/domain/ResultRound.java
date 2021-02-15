package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class ResultRound {
    private List<ResultCar> resultCars;

    public ResultRound(List<ResultCar> resultCars) {
        this.resultCars = resultCars;
    }

    public List<ResultCar> getResultCars() {
        return resultCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultRound that = (ResultRound) o;
        return Objects.equals(resultCars, that.resultCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultCars);
    }
}

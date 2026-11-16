package racingcar.dto;

import racingcar.domain.Cars;

import java.util.List;

public class RoundResult {

    List<Integer> position;

    private RoundResult(List<Integer> position) {
        this.position = position;
    }

    public static RoundResult from(Cars cars) {
        return new RoundResult(cars.getPositions());
    }

    public List<Integer> getPosition() {
        return position;
    }
}

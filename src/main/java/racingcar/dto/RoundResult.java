package racingcar.dto;

import racingcar.domain.RacingCar;

import java.util.List;

public class RoundResult {

    List<Integer> position;

    private RoundResult(List<Integer> result) {
        this.position = result;
    }

    public static RoundResult from(RacingCar racingCar) {
        return new RoundResult(racingCar.getPositions());
    }

}

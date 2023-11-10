package racingcar.ui.dto;

import racingcar.domain.Car;

import java.util.HashMap;
import java.util.List;

public class RacingGameResponse {
    private HashMap<Integer, List<Car>> movedCarsByTurn;
    private List<String> winners;

    public RacingGameResponse(HashMap<Integer, List<Car>> movedCarsByTurn, List<String> winners) {
        this.movedCarsByTurn = movedCarsByTurn;
        this.winners = winners;
    }

    public HashMap<Integer, List<Car>> getMovedCarsByTurn() {
        return movedCarsByTurn;
    }

    public List<String> getWinners() {
        return winners;
    }
}

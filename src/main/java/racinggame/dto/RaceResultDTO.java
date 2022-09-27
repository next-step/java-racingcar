package racinggame.dto;

import racinggame.domain.Car;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by seungwoo.song on 2022-09-26
 */
public class RaceResultDTO {

    private List<List<CarMoveInfo>> raceResult = new ArrayList<>();
    private List<Car> winners;

    public List<List<CarMoveInfo>> getRaceResult() {
        return raceResult;
    }

    public void addCarMoveResult(List<Car> cars) {
        raceResult.add(
                cars.stream()
                        .map(CarMoveInfo::new)
                        .collect(toList()));
    }

    public List<Car> winners() {
        return winners;
    }

    public void addWinners(List<Car> winners) {
        this.winners = winners;
    }
}

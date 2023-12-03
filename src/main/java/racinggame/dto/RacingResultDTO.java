package racinggame.dto;

import racinggame.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingResultDTO {

    private final List<Car> carList;
    private final List<String> winners;

    private final List<RacingRoundResultDTO> racingRoundResultDTOS;

    public RacingResultDTO(List<Car> carList, List<String> winners, List<RacingRoundResultDTO> racingRoundResultDTOS) {
        this.carList = new ArrayList<>(carList);
        this.winners = new ArrayList<>(winners);
        this.racingRoundResultDTOS = new ArrayList<>(racingRoundResultDTOS);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<RacingRoundResultDTO> getRacingRoundResultDTOS() {
        return racingRoundResultDTOS;
    }

}

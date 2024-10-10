package racing.domain.dto;

import racing.domain.car.Car;

import java.util.List;

public class RacingResultDTO {
    private List<CarDTO> carResult;
    private int round;

    public RacingResultDTO(List<CarDTO> carResult, int round) {
        this.carResult = carResult;
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    public List<CarDTO> getCarResult() {
        return carResult;
    }
}

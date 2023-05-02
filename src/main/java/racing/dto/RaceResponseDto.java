package racing.dto;

import racing.model.Car;
import racing.model.Cars;

import java.util.List;

public class RaceResponseDto {
    private List<Cars> results;
    private List<Car> winners;

    public RaceResponseDto(List<Cars> results, List<Car> winners) {
        this.results = results;
        this.winners = winners;
    }

    public List<Cars> getResults() {
        return results;
    }

    public List<Car> getWinners() {
        return winners;
    }
}

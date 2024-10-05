package racingCar.step5.domain.dto;

import racingCar.step5.domain.RacingCar;
import racingCar.step5.domain.RacingCars;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCarGameResult {
    private List<CarDto> racingResults;
    private List<WinnerDto> winners;

    public RacingCarGameResult() {
        racingResults = new ArrayList<>();
        winners = new ArrayList<>();
    }

    public void addRacingResult(RacingCars cars){
        for (RacingCar car : cars.getCars()) {
            this.racingResults.add(new CarDto(car.getName(), car.getPosition()));
        }
    }

    public List<CarDto> getRacingResults() {
        return racingResults;
    }

    public void addWinner(List<RacingCar> winners) {
        for (RacingCar winner : winners) {
            this.winners.add(new WinnerDto(winner.getName()));
        }
    }

    public List<WinnerDto> getWinners(){
        return winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarGameResult that = (RacingCarGameResult) o;
        return Objects.equals(racingResults, that.racingResults) && Objects.equals(winners, that.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingResults, winners);
    }
}

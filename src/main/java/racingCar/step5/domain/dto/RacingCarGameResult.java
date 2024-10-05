package racingCar.step5.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGameResult {
    private List<CarDto> racingResults;
    private List<WinnerDto> winners;

    public RacingCarGameResult() {
        racingResults = new ArrayList<>();
        winners = new ArrayList<>();
    }

    public void addRacingResult(CarDto racingResult){
        this.racingResults.add(racingResult);
    }

    public List<CarDto> getRacingResults() {
        return racingResults;
    }

    public void addWinner(WinnerDto winner) {
        this.winners.add(winner);
    }

    public List<WinnerDto> getWinners(){
        return winners;
    }
}

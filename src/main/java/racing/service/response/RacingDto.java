package racing.service.response;

import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingDto {
    private List<Cars> roundResults;
    private List<String> winnerNames;

    public RacingDto(Cars cars) {
        this.roundResults = new ArrayList<>();

        this.roundResults.add(new Cars(cars));
    }

    public void addRoundResult(Cars cars) {
        this.roundResults.add(new Cars(cars));
    }

    public List<Cars> getRoundResults() {
        return roundResults;
    }

    public void addWinnerNames(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }
}

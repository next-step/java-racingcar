package racing.dto;

import racing.car.ReadonlyCar;

import java.util.ArrayList;
import java.util.List;

public class RacingReport {

    private final List<RoundResult> racingHistories = new ArrayList<>();
    private final List<String> winners = new ArrayList<>();

    public void saveRoundResult(List<? extends ReadonlyCar> carList) {
        racingHistories.add(new RoundResult(carList));
    }

    public List<RoundResult> getRacingHistories() {
        return racingHistories;
    }

    public void addWinner(String name) {
        winners.add(name);
    }

    public List<String> getWinners() {
        return winners;
    }
}

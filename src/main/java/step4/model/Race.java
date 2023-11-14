package step4.model;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static final String END_OF_ROUND = "";
    private final List<Round> rounds;

    private final RacingCars racingCars;

    public Race(List<Round> rounds, RacingCars racingCars) {
        this.rounds = rounds;
        this.racingCars = racingCars;
    }

    public void race(String movingStr) {
        for (Round round : rounds) {
            round.run(movingStr);
            System.out.println(END_OF_ROUND);
        }
    }

    public static Race of(RacingCars racingCars, int roundCount) {
        List<Round> rounds = new ArrayList<>();
        for (int i = 0; i < roundCount; i++) {
            rounds.add(new Round(racingCars, new RandomNumberUnderTenGenerator()));
        }
        return new Race(rounds, racingCars);
    }

    public String getWinnerNames() {
        Winners winners = new Winners();
        for (Car car : racingCars.getCars()) {
            winners.addWinners(car);
        }
        return winners.getWinnerNames();
    }

}

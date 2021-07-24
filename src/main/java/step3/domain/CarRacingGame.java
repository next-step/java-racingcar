package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private List<Round> playedRounds = new ArrayList<>();

    public void gameStart(GameSetting gameSetting) {
        int carCount = gameSetting.getCarCount();
        int roundCount = gameSetting.getRoundCount();

        RacingCars cars = new RacingCars(carCount);

        for (int i = 0; i < roundCount; i++) {
            playOneRound(cars);
        }
    }

    private void playOneRound(RacingCars cars) {
        Round round = new Round();
        round.start(cars);

        playedRounds.add(round);
    }
}

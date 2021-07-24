package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private GameSetting gameSetting;
    private List<Round> playedRounds = new ArrayList<>();

    public CarRacingGame(GameSetting gameSetting) {
        this.gameSetting = gameSetting;
    }

    public void gameStart() {
        RacingCars cars = new RacingCars(gameSetting);
        playAllRounds(cars);
    }


    private void playAllRounds(RacingCars cars) {
        int roundCount = gameSetting.getRoundCount();

        for (int i = 0; i < roundCount; i++) {
            playOneRound(cars);
        }
    }

    private void playOneRound(RacingCars cars) {
        Round round = new Round();
        round.start(cars, gameSetting);

        playedRounds.add(round);
    }

    public List<Round> getPlayedRounds() {
        return playedRounds;
    }
}

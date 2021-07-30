package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    private final GameSetting gameSetting;
    private CarRacingGameResult gameResult;

    public CarRacingGame(GameSetting gameSetting) {
        List<Round> playedRounds = new ArrayList<>();

        this.gameSetting = gameSetting;
        this.gameResult = new CarRacingGameResult(playedRounds);
    }

    public void gameStart() {
        RacingCars cars = new RacingCars(gameSetting);
        playAllRounds(cars);
    }


    private void playAllRounds(RacingCars cars) {
        int roundCount = gameSetting.getRoundCount().value();

        for (int i = 0; i < roundCount; i++) {
            playOneRound(cars);
        }
    }

    private void playOneRound(RacingCars cars) {
        Round round = new Round();
        round.start(cars, gameSetting);

        gameResult.addRound(round);
    }

    public CarRacingGameResult getCarRacingGameResult() {
        return gameResult;
    }
}

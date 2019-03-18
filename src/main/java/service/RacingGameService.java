package service;

import domain.RacingGame;
import domain.RacingGameInfo;
import domain.RacingGameResult;
import domain.RandomNumberRule;

import java.util.List;

public class RacingGameService {
    public RacingGameInfo initGameInfo(Integer gameCount, List<String> carNames){
        return new RacingGameInfo(
            new RandomNumberRule(0, 10, 4),
            gameCount, carNames
        );
    }

    public RacingGameResult playGames(RacingGameInfo racingGameInfo) {
        RacingGame racingGame = new RacingGame(racingGameInfo);
        return racingGame.play();
    }
}

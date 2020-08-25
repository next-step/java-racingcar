package racingcar.domain;

import java.util.ArrayList;

import java.util.List;

import static racingcar.utils.StringUtils.isNullOrBlank;


public class RacingGamesFactory {

    public static List<RacingGame> createRacingGames(String carNames, int racingCounts) {
        List<RacingGame> racingGameList = new ArrayList<>();
        if (racingCounts == 0) {
        }
        for (int i = 0 ; i < racingCounts ; i++) {
            racingGameList.add(new RacingGame(carNames));
        }
        return racingGameList;
    }

}

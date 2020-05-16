package racing.service;

import racing.domain.RacingGame;
import racing.domain.RandomMovement;
import racing.dto.CarRaceResult;
import racing.dto.RaceInformation;
import racing.dto.RacingGameResult;
import racing.utils.EmptyCheckUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGameService {

    public List<RacingGameResult> executeRace(RaceInformation raceInformation) {
        EmptyCheckUtil.emptyCheck(raceInformation);
        RacingGame racingGame = new RacingGame(raceInformation, new RandomMovement(new Random()));
        List<CarRaceResult> carRaceResults;
        List<RacingGameResult> racingGameResults = new ArrayList<>();

        for (int i = 0; i < raceInformation.getTotalRacingCount(); i++) {
            racingGame.executeRacing();
            carRaceResults = racingGame.calculateCarRaceResults();
            racingGameResults.add(new RacingGameResult(carRaceResults, i + 1));
        }

        return racingGameResults;
    }
}

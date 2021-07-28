package racingcar;

import racingcar.race.Race;
import racingcar.race.RaceResult;

public class RacingCarApplication {

    public static void main(String[] args) {
        Race race = new Race();
        race.startRace();

        RaceResult result = new RaceResult(race);
        result.printRaceResult();
    }

}

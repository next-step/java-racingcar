package racingcar;

import java.util.List;
import racingcar.domain.Race;
import racingcar.module.IntScanner;
import racingcar.module.StringScanner;

public class Main {

    public static void main(String[] args) {
        List<String> carNames = StringScanner.insertCarNameList();
        int raceCount = IntScanner.insertRaceCount();

        Race race = new Race.RaceBuilder()
                .setCarNames(carNames)
                .setRaceCount(raceCount)
                .build();
        race.startRace();
    }
}

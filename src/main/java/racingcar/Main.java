package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Race;
import racingcar.domain.RacingCars;
import racingcar.domain.RandomNumbers;
import racingcar.module.IntScanner;
import racingcar.module.ResultView;
import racingcar.module.StringScanner;

public class Main {
    public static void main(String[] args) {
        List<String> carNames = StringScanner.insertCarNameList();
        int raceCount = IntScanner.insertRaceCount();

        List<RandomNumbers> randoms = new ArrayList<>();
        for (int i = 0; i < raceCount; ++i) {
            randoms.add(new RandomNumbers(carNames.size()));
        }

        Race race = new Race(raceCount, RacingCars.of(carNames));
        race.startRace(randoms);

        ResultView.printResult(race);
    }
}

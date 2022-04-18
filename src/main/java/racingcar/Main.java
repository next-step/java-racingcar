package racingcar;

import java.util.List;
import racingcar.domain.Race;
import racingcar.domain.RaceCondition;
import racingcar.module.IntScanner;
import racingcar.module.StringScanner;

public class Main {
    private static final int INT_RANGE = 10;
    private static final int MOVE_CONDITION = 4;

    public static void main(String[] args) {
        List<String> carNames = StringScanner.insertCarNameList();
        int raceCount = IntScanner.insertRaceCount();

        Race race = new Race(carNames, raceCount, new RaceCondition(INT_RANGE, MOVE_CONDITION));
        race.startRace();
    }
}

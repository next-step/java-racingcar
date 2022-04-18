package racingcar;

import racingcar.domain.Race;
import racingcar.domain.RaceCondition;
import racingcar.module.IntScanner;

public class Main {
    private static final int INT_RANGE = 10;
    private static final int MOVE_CONDITION = 4;

    public static void main(String[] args) {
        int carCount = IntScanner.insertCarCount();
        int raceCount = IntScanner.insertRaceCount();

        Race race = new Race(carCount, raceCount, new RaceCondition(INT_RANGE, MOVE_CONDITION));
        race.startRace();
    }
}

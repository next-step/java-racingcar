package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.Movable;
import racingcar.util.RandomUtil;

public class RacingGame implements Movable {

    private static final int RANDOM_START = 0;
    private static final int RANDOM_END = 9;
    private static final String LINE = "----------------\n";

    private final List<RacingCar> racingCarLists;
    private final int raceCount;

    public RacingGame(List<String> nameList, int raceCount) {
        racingCarLists = new ArrayList<>();
        this.raceCount = raceCount;

        for (String name : nameList) {
            racingCarLists.add(new RacingCar(name));
        }
    }

    public void runRace() {
        for(int i = 0; i < raceCount; i++) {
            moveForwardAll();
        }
    }

    @Override
    public void moveForwardAll() {
        for (RacingCar racingCar : racingCarLists) {
            racingCar.moveForward(RandomUtil.pickNumberInRange(RANDOM_START, RANDOM_END));
            String currentStatus = racingCar.getName() + ":" + racingCar.getPosition() + "\n";
            GameStatus.setStatus(currentStatus);
        }
        GameStatus.setStatus(LINE);
    }

    public List<RacingCar> getRacingCarLists() {
        return Collections.unmodifiableList(racingCarLists);
    }
}

package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.MoveUtil;

public class RacingGame {

    private static final int GAME_COUNT_LAST = 0;

    private final List<RacingCar> racingCarLists;

    public RacingGame(List<String> nameList) {
        racingCarLists = new ArrayList<>();
        for (String name : nameList) {
            racingCarLists.add(new RacingCar(name));
        }
    }

    public String getGameStatus(int raceCount) {
        StringBuilder currentResult = new StringBuilder();
        while (raceCount > GAME_COUNT_LAST) {
            currentResult.append(MoveUtil.moveForwardAll(racingCarLists));
            raceCount--;
        }
        return currentResult.toString();
    }

    public List<RacingCar> getRacingCarLists() {
        return Collections.unmodifiableList(racingCarLists);
    }
}

package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {


    private final List<RacingCar> racingCarLists;

    public RacingGame(List<String> nameList) {
        racingCarLists = new ArrayList<>();
        for (String name : nameList) {
            racingCarLists.add(new RacingCar(name));
        }
    }

    public List<RacingCar> getRacingCarLists() {
        return Collections.unmodifiableList(racingCarLists);
    }


}

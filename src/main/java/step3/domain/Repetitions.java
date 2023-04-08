package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Repetitions implements Cloneable {

    private final int repetitions;
    private final List<RacingCar> racingCarList;

    private Repetitions(int repetitions, List<RacingCar> racingCarList) {
        this.repetitions = repetitions;
        this.racingCarList = racingCarList;
    }


    public int getRepetitions() {
        return repetitions;
    }

    public List<RacingCar> getCarList() {
        return racingCarList;
    }

    public static Repetitions recordOf(int repetitions, List<RacingCar> racingCarList) {

        return new Repetitions(repetitions, copyRacingCarList(racingCarList));
    }

    private static List<RacingCar> copyRacingCarList(List<RacingCar> racingCarList) {
        return racingCarList.stream()
                .map(RacingCar::copyOf)
                .collect(Collectors.toList());
    }
}


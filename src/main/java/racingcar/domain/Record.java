package racingcar.domain;

import racingcar.exception.RacingGameException;

import java.util.List;
import java.util.stream.Collectors;

public final class Record {

    private final int lab;
    private final List<RacingCar> racingCars;

    private Record(int lab, List<RacingCar> racingCars) {
        this.lab = lab;
        this.racingCars = racingCars;
    }

    public static Record record(int lab, List<RacingCar> racingCars) {
        List<RacingCar> racingCarSnapshots = racingCars.stream()
                .map(Record::snapshot)
                .collect(Collectors.toList());

        return new Record(lab, racingCarSnapshots);
    }

    private static RacingCar snapshot(RacingCar racingCar) {
        RacingCar snapshot = null;

        try {
            snapshot = racingCar.clone();
        } catch (CloneNotSupportedException e) {
            throw new RacingGameException("기록을 저장하는 과정에 문제가 발생했습니다.");
        }

        return snapshot;
    }

    public int getLab() {
        return lab;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }
}

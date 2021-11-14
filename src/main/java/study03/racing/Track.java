package study03.racing;

import study03.racing.car.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Track {

    private final List<RacingCar> racingCarList;

    public Track() {
        this.racingCarList = new ArrayList<>();
    }

    public Track(List<RacingCar> racingCarList) {
        this.racingCarList = racingCarList;
    }

    public void addRacingCar() {
        racingCarList.add(new RacingCar());
    }

    public void addRacingCar(int addedCount) {
        IntStream.range(0, addedCount)
                .forEach(i -> addRacingCar());
    }

    public List<Boolean> moveAll() {
        return racingCarList.stream()
                .map(RacingCar::move)
                .collect(Collectors.toList());
    }

    public List<String> trackingAll() {
        return racingCarList.stream()
                .map(RacingCar::currentMoveDistance)
                .collect(Collectors.toList());
    }
}

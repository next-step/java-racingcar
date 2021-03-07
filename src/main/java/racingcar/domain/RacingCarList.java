package racingcar.domain;

import racingcar.dto.CarScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarList {

    private final List<RacingCar> racingCarList = new ArrayList<>();

    public void add(RacingCarGameRule racingCarGameRule, String carName) {
        racingCarList.add(new RacingCar(racingCarGameRule, carName));
    }

    public void addBulk(RacingCarGameRule racingCarGameRule, String[] carNameArray) {
        Arrays.stream(carNameArray)
                .forEach(carName -> add(racingCarGameRule, carName));
    }

    public void move() {
        racingCarList.forEach(RacingCar::move);
    }

    public List<CarScore> getIndividualScore() {
        return racingCarList.stream()
                .map(CarScore::new)
                .collect(Collectors.toList());
    }

}

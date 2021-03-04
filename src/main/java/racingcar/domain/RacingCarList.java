package racingcar.domain;

import racingcar.dto.CarScore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarList {

    private final List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCarList(int carNumber, MovingStrategy movingStrategy) {
        for (int i = 0; i < carNumber; i++) {
            racingCarList.add(new RacingCar(movingStrategy));
        }
    }

    public RacingCarList(int carNumber) {
        this(carNumber, new DecidingNumberBasedMovingStrategy());
    }

    public void move() {
        racingCarList.forEach(RacingCar::move);
    }

    public List<CarScore> getIndividualScore(){
        return racingCarList.stream()
                .map(CarScore::new)
                .collect(Collectors.toList());
    }

}

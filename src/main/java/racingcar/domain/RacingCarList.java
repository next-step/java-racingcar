package racingcar.domain;

import racingcar.dto.CarScore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarList {

    private List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCarList(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            racingCarList.add(new RacingCar());
        }
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

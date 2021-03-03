package racingcar.domain;

import racingcar.dto.CarScore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarList {

    private List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCarList(List<String> carNameList) {
        racingCarList=carNameList.stream().map(RacingCar::new).collect(Collectors.toList());
    }

    public void move() {
        racingCarList.forEach(RacingCar::move);
    }

    public List<CarScore> getIndividualScore(){
        return racingCarList.stream().map(CarScore::new)
                .collect(Collectors.toList());
    }

}

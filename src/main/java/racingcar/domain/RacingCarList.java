package racingcar.domain;

import racingcar.dto.CarScore;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarList {

    private final List<RacingCar> racingCarList;

    public RacingCarList(RacingCarGameRule racingCarGameRule,String[] carNameArray) {
        racingCarList= Arrays.stream(carNameArray)
                .map(name -> new RacingCar(racingCarGameRule,name))
                .collect(Collectors.toList());
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

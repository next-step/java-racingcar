package carRacing.model;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private List<Car> racingCars;

    public RacingCars(String carNames) {
        if(Strings.isNullOrEmpty(carNames)) throw new IllegalArgumentException("자동차 이름을 찾을 수 없습니다.");

        String[] splitCarNames = nameSplit(carNames);
        this.racingCars = prepareRace(splitCarNames);
    }


    private String[] nameSplit(String carNames) {
        return carNames.split(",");
    }

    private List<Car> prepareRace(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new).collect(Collectors.toList());
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}

package carRacing.model;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private List<Car> racingCars;

    public RacingCars(String[] carNames) {
        if(carNames == null) throw new NullPointerException("배열 형태의 자동차 이름을 입력해주세요");
        this.racingCars = prepareRace(carNames);
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

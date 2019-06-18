package carRacing.model;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RaceCars {

    private List<Car> raceCars;

    public RaceCars(String carNames) {
        if(Strings.isNullOrEmpty(carNames)) throw new IllegalArgumentException("자동차 이름을 찾을 수 없습니다.");

        String[] splitCarNames = nameSplit(carNames);
        this.raceCars = prepareRace(splitCarNames);
    }

    private String[] nameSplit(String carNames) {
        return carNames.split(", ");
    }

    private List<Car> prepareRace(String[] carNames) {
        return Arrays.stream(carNames)
                .map(carName -> new Car(carName)).collect(Collectors.toList());
    }

    public List<Car> getRaceCars() {
        return raceCars;
    }
}

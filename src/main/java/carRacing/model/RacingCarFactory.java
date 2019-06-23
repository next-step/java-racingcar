package carRacing.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarFactory {

    private String[] carNames;

    public RacingCarFactory(String[] carNames) {
        if(carNames == null) throw new NullPointerException("배열 형태의 자동차 이름을 입력해주세요");
        this.carNames = carNames;
    }

    public RacingCars manufacture() {
        List<Car> carList = Arrays.stream(this.carNames)
                .map(Car::new).collect(Collectors.toList());
        return new RacingCars(carList);
    }
}

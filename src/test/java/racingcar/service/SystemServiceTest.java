package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.vo.Car;

import java.util.ArrayList;
import java.util.List;

public class SystemServiceTest extends Util {

    private List<Car> carInfo = new ArrayList<>();

    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"jeonggggg,hyeon,jin"})
    public void splitString(String input) {
        String[] result = input.split(",");
        for (int i = 0; i < result.length; i++) {
            Car carVO = new Car(result[i], 0);
            if (invalidedName(result[i])) {
                carInfo.add(carVO);
            }
        }
    }

}

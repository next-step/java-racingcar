package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.CarNames;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {

    @ParameterizedTest
    @DisplayName("입력 받은 문자열로 CarNames를 만드는 지에 대한 Test")
    @ValueSource(strings = {"car1", "car1,car2,car3"})
    void makeCarNamesTest(String carName) {
        CarNames carNames = new CarNames(carName);
        assertThat(carNames).isInstanceOf(CarNames.class);
    }

    @ParameterizedTest
    @DisplayName("CarNames이 제대로 들어갔는지에 대한 Test")
    @ValueSource(strings = {"car1", "car1,car2,car3"})
    void checkCarNamesTest(String carName) {
        //when
        CarNames carNames = new CarNames(carName);

        //then
        List<String> carNameList = carNames.getCarNames();

        assertThat(carNameList.get(0)).isEqualTo("car1");
    }

}

package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.CarNames;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {

    @ParameterizedTest
    @DisplayName("입력 받은 문자열로 CarNames를 만드는 지에 대한 Test")
    @ValueSource(strings = {"car1", "car1,car2,car3"})
    void makeCarTest(String carName) {
        CarNames carNames = new CarNames(carName);
        assertThat(carNames).isInstanceOf(CarNames.class);
    }

}

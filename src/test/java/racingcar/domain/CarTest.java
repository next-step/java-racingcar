package step3.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("자동차 멈추는 기능 구현")
    void randomValueTest(int input) {
        Car car = new Car(input);
    }
}

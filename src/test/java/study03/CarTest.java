package study03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @RepeatedTest(value = 100, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName("0~9의 임의의 조건값 생성")
    void 조건값생성() {
        Car car = new Car();
        assertThat(car.createConditionNumber()).isGreaterThanOrEqualTo(0);
        assertThat(car.createConditionNumber()).isLessThanOrEqualTo(9);
    }

}
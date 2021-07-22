package study.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static study.calculator.Common.toInt;

class CarTest {

    @ParameterizedTest
    @CsvSource({"1,1","2,2","3,3","4,4","5,5"})
    void 차거리입력생성테스트(String input, String expected) {
        Car car = new Car(toInt(input));
        assertThat(car.getDistance().getMove()).isEqualTo(toInt(expected));
    }

}
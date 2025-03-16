package edu.nextstep.camp.carracing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @CsvSource(value = {
            "0,''",
            "1,''",
            "2,''",
            "3,''",
            "4,'-'",
            "5,'-'",
            "6,'-'",
            "7,'-'",
            "8,'-'",
            "9,'-'"
    })
    void 숫자에_따른_차_이동_후_position_테스트(int number, String expectedPosition) {
        // Given
        Car car = new Car("myCar");

        // When
        car.move(number);

        // Then
        assertThat(car.getPositionString()).isEqualTo(expectedPosition);
    }
}

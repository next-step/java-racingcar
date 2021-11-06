package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }


    @DisplayName("자동차 전진후 상태 테스트")
    @ParameterizedTest(name = "{0}, {1}값이 주어질 경우 움직임결과 {2}")
    @CsvSource(value = {
            "6 | 6 | '--'",
            "8 | 2 | '-'",
            "2 | 2 | ''",
            "4 | 1 | '-'"
    }, delimiter = '|')
    void advance(int moveValue1, int moveValue2,  String expected) {
        car.advance(moveValue1);
        car.advance(moveValue2);
        assertThat(car.advanceStatus()).isEqualTo(expected);
    }

}
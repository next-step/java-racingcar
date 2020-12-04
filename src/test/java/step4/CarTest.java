package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("jack");
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 IllegalArgumentException 발생")
    void length_IllegalArgumentException() {
        assertThatThrownBy(()-> {
            car = new Car("jackcoding");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:''","3:''", "4:-", "5:-" }, delimiter = ':')
    @DisplayName("4이상 전진, 4미만 정지 기능 테스트")
    void move(int input, String expected) {
        car.move(input);
        Assertions.assertThat(car.getDistance()).isEqualTo(expected);
    }

}

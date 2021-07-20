package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("자동차 객체는 입력값에 따라 전진 여부를 판단 할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"4:true", "3:false", "0:false", "9:true"}, delimiter = ':')
    void car_movable(int num , boolean expected) {
        assertThat(car.race(num)).isEqualTo(expected);
    }

    @DisplayName("자동차 객체가 전진 가능 할 경우 position 값을 증가 시킨다.")
    @ParameterizedTest
    @CsvSource(value = {"4:1", "3:0", "0:0", "9:1"}, delimiter = ':')
    void car_position(int num , int position) {
        car.race(num);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("하나의 자동차 객체가 여러번 시도했을 때의 position 값 테스트 ")
    @Test
    void position_count() {
        car.race(4);
        car.race(3);
        car.race(9);

        assertThat(car.getPosition()).isEqualTo(2);
    }
}

package racing;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DisplayName("Car 클래스 테스트")
class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "3:false", "5:true"}, delimiter = ':')
    @DisplayName("주사위 값에 따라 움직 여부를 정하는 메소드 테스트")
    void isMoveTimeTest(int input, boolean expected) {
        assertThat(car.isMoveTime(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동이 잘되었는지 포지션 테스트")
    void positionTest() {
        car.move();
        assertThat(car.showMyPosition()).isEqualTo(1);
    }
}
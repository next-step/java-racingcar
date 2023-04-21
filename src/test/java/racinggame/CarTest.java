package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racinggame.Car.CAR_NAME_STANDARD;

public class CarTest {

    @DisplayName("자동차 이름은" + CAR_NAME_STANDARD + "자를 초과할 수 없습니다.")
    @Test
    void test3() {
        assertThatThrownBy(() -> new Car("dosaem"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("자동차 이름은 %d자를 초과할 수 없습니다.", CAR_NAME_STANDARD));
    }

    @DisplayName("자동차 이름 입력받기 테스트")
    @Test
    void test2() {
        Car car = new Car("saem");
        assertThat(car.getName()).isEqualTo("saem");
    }

    @DisplayName("random 값이 4미만인 경우 멈춤, 4이상인 경우 전진")
    @ParameterizedTest(name = "{displayName} {index} = 랜덤값: {0} -> 결과: {1}")
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void test1(int input, int result) {
        Car car = new Car();
        assertThat(car.move(input)).isEqualTo(result);
    }

}

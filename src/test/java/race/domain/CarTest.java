package race.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("차가 한번 전진할 때 1만큼 움직인다는 것을 테스트한다")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    void go_three_times(int times, int expected) {
        Car car = new Car(0, "임형준");
        for (int i = 0; i < times; i++) {
            car.go();
        }
        assertThat(car.getPosition()).isEqualTo(expected);
    }

    @DisplayName("car의 이름에 대한 검증 책임 테스트")
    @Test
    void exception_name_test() {
        assertThatThrownBy(() -> {
            new Car(0, "");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백없이 정확한 이름을 입력해주세요.");
    }

    @DisplayName("car의 position에 대한 검증 책임 테스트")
    @Test
    void exception_position_test() {
        //given
        int negativePosition = -1;

        assertThatThrownBy(() -> {
            new Car(negativePosition, "임형준");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format(
                        "(%s)은 음수입니다. 차의 위치(position)는 0이상의 양의 정수만 허용됩니다.",
                        negativePosition));
    }

}

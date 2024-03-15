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

    @Test
    void exception_test() {
        assertThatThrownBy(() -> {
            new Car(0, "");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백없이 정확한 이름을 입력해주세요.");
    }

}

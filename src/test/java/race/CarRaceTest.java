package race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import race.vehicle.Vehicles;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRaceTest {
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 7})
    @DisplayName("숫자를 입력받으면 자동차가 성공적으로 생성되는지 확인한다")
    void 자동차_생성(int value) {
        Vehicles vehicles = new Vehicles(value);

        Assertions.assertThat(vehicles.getList()).hasSize(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0 , -1})
    @DisplayName("2 미만의 숫자를 입력받으면 예외를 발생시킨다")
    void 자동차_부족(int value)
    {
        assertThatThrownBy(() -> {
            Vehicles vehicles = new Vehicles(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임을 진행할 수 없음");
    }
}

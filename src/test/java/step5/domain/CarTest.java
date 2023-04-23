package step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("Car의 이름은 빈칸이거나 5를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "테스트 이름", "테스트용 이름"})
    public void carNameTest(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name, () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("전진한 경우, Position을 증가시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 3, 5, 6})
    public void raceMoveTest(int tryCount) {
        Car car = new Car("test", () -> true);

        for (int i = 0; i < tryCount; i++) {
            car.race();
        }

        Assertions.assertThat(car.getNowPosition()).isEqualTo(tryCount + 1);
    }

    @DisplayName("멈춘 경우, Position을 증가시키지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 3, 5, 6})
    public void raceStopTest(int tryCount) {
        Car car = new Car("test", () -> false);

        for (int i = 0; i < tryCount; i++) {
            car.race();
        }

        Assertions.assertThat(car.getNowPosition()).isEqualTo(1);
    }

}

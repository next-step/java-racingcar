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
        String name = "test";
        Car car = new Car(name, () -> true);
        StringBuilder expected = new StringBuilder(name);
        expected.append(" : -");

        String result = null;
        for (int i = 0; i < tryCount; i++) {
            result = car.race();
            expected.append("-");
        }

        Assertions.assertThat(result).isEqualTo(expected.toString());
    }

    @DisplayName("멈춘 경우, Position을 증가시키지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 3, 5, 6})
    public void raceStopTest(int tryCount) {
        String name = "test";
        Car car = new Car(name, () -> false);
        String expected = name + " : -";

        String result = null;
        for (int i = 0; i < tryCount; i++) {
            result = car.race();
        }

        Assertions.assertThat(result).isEqualTo(expected);
    }

}

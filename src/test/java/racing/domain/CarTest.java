package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("랜덤 결과가 4이상인 경우 한 칸 전진한다.")
    @ValueSource(ints = { 4, 9 })
    @ParameterizedTest
    void 전진(int randomResult) {
        //given
        int carBeforeLocation = car.getLocation();

        //when
        car.run(randomResult);

        //then
        assertThat(car.getLocation()).isEqualTo(carBeforeLocation + 1);
    }

    @DisplayName("랜덤 결과가 4미만이면 멈춰 있는다.")
    @ValueSource(ints = { 0, 3 })
    @ParameterizedTest
    void 정지(int randomResult) {
        //given
        int carBeforeLocation = car.getLocation();

        //when
        car.run(randomResult);

        //then
        assertThat(car.getLocation()).isEqualTo(carBeforeLocation);
    }

    @DisplayName("랜덤 결과는 0 ~ 9사이여야 한다. 그 외 범위라면 IllegalArgumentException이 발생한다.")
    @ValueSource(ints = { -1, 10 })
    @ParameterizedTest
    void 게임결과_범위(int randomResult) {
        assertThatThrownBy(() -> car.run(randomResult))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

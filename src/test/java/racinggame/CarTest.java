package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 객체 Car 테스트")
public class CarTest {

    private Car car;

    @BeforeEach
    void initCar() {
        car = new Car();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    public void 주행(int condition) {
        boolean result = car.run(new MoveCondition(condition));

        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    public void 정지(int condition) {
        boolean result = car.run(new MoveCondition(condition));

        assertThat(result).isFalse();
    }
}

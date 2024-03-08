package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @Test
    public void 생성자_초기위치_0() {
        assertThat(car.position()).isEqualTo(new Position(0));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    public void 주행(int condition) {
        car.run(new MoveCondition(condition));

        assertThat(car.position()).isEqualTo(new Position(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    public void 정지(int condition) {
        car.run(new MoveCondition(condition));

        assertThat(car.position()).isEqualTo(new Position(0));
    }
}

package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.Car;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private Car car = null;

    @BeforeEach
    public void setUp() {
        car = new Car("HO", 1);
    }


    @DisplayName("입력값이 4미만 포지션의 위치값 변화 없음")
    @Test
    public void moveLessCondition() {

        int beforePosition = car.getPosition();

        car.move(3);

        int afterPosition = car.getPosition();

        assertThat(car.getPosition()).isEqualTo(1);
        assertThat(beforePosition).isEqualTo(afterPosition);

    }

    @DisplayName("입력값이 4이상일때 위치값 변화 있음")
    @Test
    public void moveGreaterCondition() {

        int beforePosition = car.getPosition();

        car.move(4);

        int afterPosition = car.getPosition();

        assertThat(car.getPosition()).isEqualTo(2);
        assertThat(afterPosition - beforePosition).isEqualTo(1);


    }

    @DisplayName("외부에서 입력한 최대값과 동일한지 비교")
    @ParameterizedTest
    @MethodSource
    public void isSamePosition(int input, boolean result) {
        Car customCar = new Car("Custom",5);
        boolean checkResult = customCar.isSamePosition(input);
        assertThat(checkResult).isEqualTo(result);
    }

    private static Stream<Arguments> isSamePosition() {
        return Stream.of(
                Arguments.of(5, true),
                Arguments.of(2, false));
    }

}
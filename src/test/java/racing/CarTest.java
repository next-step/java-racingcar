package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car = null;

    @BeforeEach
    public void setUp() {
        car = new Car("HO");
    }


    @DisplayName("입력값이 4보다 작을때 포지션의 위치값 변화 없음")
    @Test
    public void moveLessCondition() {
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);

    }

    @DisplayName("입력값이 4보다 작을때 포지션의 위치값 변화 없음")
    @Test
    public void moveGreaterCondition() {
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @DisplayName("한번 이동한 자동차의 현재 위치와 외부에서 입력한 위치 최대값이 동일할때")
    @Test
    public void isSamePosition() {
        car.move(5);
        boolean checkResult = car.isSamePosition(1);
        assertThat(checkResult).isEqualTo(true);
    }

    @DisplayName("한번 이동한 자동차의 현재 위치와 외부에서 입력한 위치 최대값이 동일하지 않을때")
    @Test
    public void isNotSamePosition() {
        car.move(5);
        boolean checkResult = car.isSamePosition(2);
        assertThat(checkResult).isEqualTo(false);
    }

}
package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarTest {

    @DisplayName("차량 이동 여부 숫자가 0이상인 경우")
    @Test
    public void 차량_이동_여부_숫자가_0이상(){
        assertThat(new Car().tryMoveNumber()).isGreaterThan(-1);
    }

    @DisplayName("차량 이동 여부 숫자가 10보다 작은 경우")
    @Test
    public void 차량_이동_여부_숫자가_10보다_작음(){
        assertThat(new Car().tryMoveNumber()).isLessThan(10);
    }

    @DisplayName("시도 점수가 4보다 작은 경우 위치 고정")
    @ParameterizedTest(name="{displayName} | 시도 점수: {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    public void 시도_점수가_4보다_작은_경우_위치_고정(int tryMoveNumber){
        Car car = new Car();
        car.moveCar(tryMoveNumber);
        assertThat(car.getLocation()).isEqualTo("");
    }

    @DisplayName("시도 점수가 4이상인 경우 위치 이동")
    @ParameterizedTest(name="{displayName} | 시도 점수: {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 시도_점수가_4보다_큰_경우_위치_이동(int tryMoveNumber){
        Car car = new Car();
        car.moveCar(tryMoveNumber);
        assertThat(car.getLocation()).isEqualTo("-");
    }
}

package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class CarTest {

    @Test
    @DisplayName("자동차 이름이 5글자가 초과하면 IllegalException이 발생한다.")
    void 이름길이가_5글자_초과() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("wooooni");
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 8, 9})
    @DisplayName("랜덤값이 4이상일 경우 자동차는 전진한다.")
    void 자동차_전진(int randomNumber) {
        Car car = new Car("wooni");
        car.moveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    @DisplayName("랜덤값이 4미만일 경우 자동차는 정지한다.")
    void 자동차_정지(int randomNumber) {
        Car car = new Car("wooni");
        car.moveForward(randomNumber);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("현재 maxPosition보다 이동거리가 크다면 해당 값으로 갱신된다.")
    void 현재_맥스_포지션과_이동거리_비교() {
        Car wooni = new Car("wooni", 7);
        assertThat(wooni.checkMaxPosition(8)).isEqualTo(8);
    }

    @Test
    @DisplayName("현재 최대이동거리가 7일때, 최대이동거리 일치 여부 유효성 ")
    void 최대_이동거리_일치_여부_판단() {
        Car wooni = new Car("wonie", 7);
        int maxPosition = 7;
        assertThat(wooni.isMaxPosition(maxPosition)).isEqualTo(true);
    }
}


package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    public static final int MOVE_CONDITION = 4;
    public static final int STOP_CONDITION = 3;

    @Test
    @DisplayName("자동자 전진 확인")
    public void progressTest() {
        //given
        Car car = new Car("eli");

        //when
        car.progress(MOVE_CONDITION);

        //then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 정지 확인")
    public void stopTest() {
        //given
        Car car = new Car("eli");

        //when
        car.progress(STOP_CONDITION);

        //then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("횟수 확인")
    public void repeatTest() {
        //given
        Car car = new Car("eli");
        int repeatCount = 5;

        //when
        for (int i = 0; i < repeatCount; i++) {
            car.progress(MOVE_CONDITION);
        }

        //then
        assertThat(car.getPosition()).isEqualTo(repeatCount);
    }
}

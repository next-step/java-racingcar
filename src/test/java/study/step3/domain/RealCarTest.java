package study.step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.TestingCar;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RealCarTest {
    @Test
    @DisplayName("이동 결과는 true 또는 false 가 나온다")
    void move() {
        Car car = new RealCar("blue");
        for (int i = 0; i < 1000; i++) {
            car.move();
        }
        assertThat(new HashSet<>(car.takeDrivingRecordTake(1000))).contains(true, false);
    }

    @Test
    @DisplayName("자동차 이름이 5자가 넘으면 오류메시지를 출력한다.")
    public void whenCarNameOverFiveChar() {
        assertThatThrownBy(() -> new RealCar("yellow")) //
                .isInstanceOf(IllegalArgumentException.class) //
                .hasMessage("이름은 5자를 넘을 수 없습니다.");
    }

    @Test
    @DisplayName("이동 시도횟수를 반환한다.")
    void totalMoves() {
        Car car = new RealCar("blue");
        car.move();
        car.move();
        car.move();

        assertThat(car.getTotalTry()).isEqualTo(3);
    }

    @Test
    @DisplayName("실제 이동거리를 반환한다.")
    void distanceDriven() {
        TestingCar car = new TestingCar();
        car.move(false);
        car.move(true);
        car.move(true);
        car.move(false);

        assertThat(car.getDistanceDriven()).isEqualTo(2);
    }

}

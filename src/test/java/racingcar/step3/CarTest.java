package racingcar.step3;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CarTest {

    @Test
    @DisplayName("값이 4이상 9이하면 움직인다")
    void carMove() {
        Car car = new Car(1);
        car.move(4);
        car.move(9);
        Assertions.assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("값이 4이상 9이하가 아니면 멈춘다")
    void carStop() {
        Car car = new Car(1);
        car.move(3);
        car.move(10);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    // 랜덤값 생성으로 결과값이 바뀜...다른 방법이 필요
    @Test
    @DisplayName("랜덤값이 4이상이면 움직인다")
    void carMoveRandom() {
        Car car = new Car(1);
        car.move();
        Assertions.assertThat(car.getPosition()).isEqualTo(2);
    }

}

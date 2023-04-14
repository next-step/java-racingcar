package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {

    private Car stopCar;
    private Car moveCar;

    @BeforeEach
    void setUp() {
        stopCar = new Car(new RandomNumberGenerator(0, 4));
        moveCar = new Car(new RandomNumberGenerator(4, 5));
    }

    @DisplayName("자동차는 랜덤값이 4보다 작은값을경우 움직일 수 없다.")
    @Test
    void 정지() {
        stopCar.racing();
        assertThat(stopCar.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차는 랜덤값이 4이상일경우 1칸 이동한다.")
    @Test
    void 전진() {
        moveCar.racing();
        assertThat(moveCar.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차는 랜덤값이 4이상이 3번 나올경우 3번 전진한다.")
    @Test
    void 전진_3번() {
        assertAll(
                () -> {
                    moveCar.racing();
                    assertThat(moveCar.getPosition()).isEqualTo(1);
                },
                () -> {
                    moveCar.racing();
                    assertThat(moveCar.getPosition()).isEqualTo(2);
                },
                () -> {
                    moveCar.racing();
                    assertThat(moveCar.getPosition()).isEqualTo(3);
                }
        );
    }

    @DisplayName("자동차는 랜덤값이 4보다 작게 3번 나올경우 0번 전진한다.")
    @Test
    void 전진_0번() {
        assertAll(
                () -> {
                    stopCar.racing();
                    assertThat(stopCar.getPosition()).isEqualTo(0);
                },
                () -> {
                    stopCar.racing();
                    assertThat(stopCar.getPosition()).isEqualTo(0);
                },
                () -> {
                    stopCar.racing();
                    assertThat(stopCar.getPosition()).isEqualTo(0);
                }
        );
    }


}

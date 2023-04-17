package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.StringCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarTest {

    private static final String STOP_CAR_NAME = "stop";
    private static final String MOVE_CAR_NAME = "move";
    private static final String BLANK = "";
    private static final String OUT_RANGE_CAR_NAME = "testcarname";

    private Car stopCar;
    private Car moveCar;

    @BeforeEach
    void setUp() {
        stopCar = new Car(STOP_CAR_NAME, new RandomNumberGenerator(0, 4));
        moveCar = new Car(MOVE_CAR_NAME, new RandomNumberGenerator(4, 5));
    }

    @DisplayName("자동차 생성시 이름이 공백이면 에러를 던진다")
    @Test
    void 자동차_이름_공백검사() {
        assertThatThrownBy(() ->
                new Car(BLANK, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 생성시 이름이 5글자를 넘기면 에러를 던진다")
    @Test
    void 자동차_이름_최대길이_검사() {
        assertThatThrownBy(() ->
                new Car(OUT_RANGE_CAR_NAME, new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차는 랜덤값이 4보다 작은값을경우 움직일 수 없다.")
    @Test
    void 정지() {
        stopCar.racing();
        assertThat(stopCar.positionValue()).isEqualTo(0);
    }

    @DisplayName("자동차는 랜덤값이 4이상일경우 1칸 이동한다.")
    @Test
    void 전진() {
        moveCar.racing();
        assertThat(moveCar.positionValue()).isEqualTo(1);
    }

    @DisplayName("자동차는 랜덤값이 4이상이 3번 나올경우 3번 전진한다.")
    @Test
    void 전진_3번() {
        assertAll(
                () -> {
                    moveCar.racing();
                    assertThat(moveCar.positionValue()).isEqualTo(1);
                },
                () -> {
                    moveCar.racing();
                    assertThat(moveCar.positionValue()).isEqualTo(2);
                },
                () -> {
                    moveCar.racing();
                    assertThat(moveCar.positionValue()).isEqualTo(3);
                }
        );
    }

    @DisplayName("자동차는 랜덤값이 4보다 작게 3번 나올경우 0번 전진한다.")
    @Test
    void 전진_0번() {
        assertAll(
                () -> {
                    stopCar.racing();
                    assertThat(stopCar.positionValue()).isEqualTo(0);
                },
                () -> {
                    stopCar.racing();
                    assertThat(stopCar.positionValue()).isEqualTo(0);
                },
                () -> {
                    stopCar.racing();
                    assertThat(stopCar.positionValue()).isEqualTo(0);
                }
        );
    }


}

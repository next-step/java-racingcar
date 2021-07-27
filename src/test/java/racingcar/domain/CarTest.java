package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CarTest {
    private static final String CAR_NAME = "edge";
    private static RandomState randomState;

    @BeforeAll
    static void setUp() {
        randomState = new RandomState() {
            @Override
            boolean isMovable() {
                return true;
            }
        };
    }

    @DisplayName("자동차 이름이 5자리 이상이면 에러")
    @Test
    void checkNameValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Car("aaaaaa"));
    }

    @DisplayName("한번 이동하면 score가 1 올라가야한다.")
    @Test
    void go() {
        Car car = new Car(CAR_NAME);
        car.go(randomState);
        assertThat(car.getScore()).isEqualTo(1);
    }

    @DisplayName("car의 현재 스코어와 숫자가 같은지 비교한다.")
    @Test
    void isSameScore() {
        Car car = new Car(CAR_NAME);
        assertThat(car.isSameScore(0)).isTrue();
        car.go(randomState);
        assertThat(car.isSameScore(1)).isTrue();
    }
}

package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    private final Car car = new Car();

    @Test
    @DisplayName("조건 0~9 범위 유효성 검증")
    void validateOutOfConditionRange() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            car.play(10);
        })
                .withMessageContaining("전진 조건 범위를 초과하였습니다.");
    }

    @Test
    @DisplayName("4이상일때 전진")
    void moveTest() {
        CarStatus status = car.play(4);
        assertThat(status.isMove()).isTrue();
    }

    @Test
    @DisplayName("3 이하일때 스탑")
    void stopTest() {
        CarStatus status = car.play(3);
        assertThat(status.isStop()).isTrue();
    }
}

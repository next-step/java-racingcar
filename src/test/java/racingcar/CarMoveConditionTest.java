package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMoveConditionTest {

    @Test
    @DisplayName("[성공] 4 이상의 값을 전달받는 경우 전진 가능하다 판단한다.")
    void 자동차_전진_판단() {
        assertThat(CarMoveCondition.isMovable(5)).isTrue();
    }

    @Test
    @DisplayName("[성공][경계값 테스트] 4를 전달받는 경우 전진 가능하다 판단한다.")
    void 자동차_전진_판단_4입력() {
        assertThat(CarMoveCondition.isMovable(4)).isTrue();
    }

}

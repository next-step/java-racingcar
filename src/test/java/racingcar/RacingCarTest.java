package racingcar;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarTest {

    @DisplayName("RacingCar는 자동차 이름과 시도할 횟수가 같으면 같은 객체")
    @Test
    void 자동차경주_생성() {
        String carNames = "car1,car2";
        assertThat(RacingCar.create(carNames, 5)).isEqualTo(RacingCar.create(carNames, 5));
    }

    @DisplayName("자동차 대수가 0 이하일 경우 예외")
    @ParameterizedTest
    @NullAndEmptySource
    void 자동차경주_자동차대수_0이하_예외(String input) {
        assertThatThrownBy(() -> {
            RacingCar.create(input, 5);
        }).hasMessageContaining("자동차 이름을 입력해야 합니다.");
    }

    @DisplayName("시도횟수가 0 이하일 경우 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void 자동차경주_시도회수_0이하_예외(int input) {
        assertThatThrownBy(() -> {
            RacingCar.create("car1,car2", input);
        }).hasMessageContaining("1 이상 입력해야 합니다.");
    }

    @Disabled
    @DisplayName("자동차 이름이 없을 때 예외")
    @ParameterizedTest
    @ValueSource(strings = {",,,"})
    void 자동차경주_자동차이름_없으면_예외(String input) {
        assertThatThrownBy(() -> {
            RacingCar.create(input, 5);
        }).hasMessageContaining("자동차 이름이 없습니다.");
    }
}

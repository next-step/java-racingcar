package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.mock.MockAlwaysMaxValueRandomUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.domain.RacingCar.AVAILABLE_MAX_NAME_LENGTH;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void init() {
        racingCar = new RacingCar(new MockAlwaysMaxValueRandomUtil(), "test");
    }

    @Test
    @DisplayName("RacingCar가 전진에 모두 성공한다면 moveCount와 numberOfCountToTry가 같아야 한다.")
    void testRacingCar_moveToTry() {
        //given
        int numberOfCountToTry = 5;
        class MoveCounter {
            private int count = 0;
            private void increaseCount() {
                count++;
            }
        }
        MoveCounter moveCounter = new MoveCounter();

        //when
        for (int i = 0; i < numberOfCountToTry; i++) {
            racingCar.tryToMove();
        }
        racingCar.repeatAsMoveCount(moveCounter::increaseCount);

        //then
        assertThat(moveCounter.count).isEqualTo(numberOfCountToTry);
    }

    @Test
    @DisplayName("RacingCar의 이름이 허용된 길이를 초과하면 IllegalArgumentException")
    void testRacingCar_nameLength() {
        StringBuilder invalidNameBuilder = new StringBuilder();
        for (int i = 0; i < AVAILABLE_MAX_NAME_LENGTH + 1; i++) {
            invalidNameBuilder.append("x");
        }

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new RacingCar(invalidNameBuilder.toString()))
                .withMessage("Length of RacingCar name cannot exceed " + AVAILABLE_MAX_NAME_LENGTH);
    }
}

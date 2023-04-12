package step3;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class CarGameTest {

    @Test
    void 자동차게임_생성() {
        int numberOfCars = 3;
        int numberOfMoves = 5;

        assertThatCode(() -> new CarGame(numberOfCars, numberOfMoves))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차게임_생성시_입력값이_0미만인경우_예외발생() {
        int numberOfCars = -3;
        int numberOfMoves = -5;

        assertThatThrownBy(() -> new CarGame(numberOfCars, numberOfMoves))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 랜덤숫자_생성_0이상_10미만() {
        for (int i = 0; i < 20; i++) {
            int randomNumber = new Random().nextInt(10);
            assertThat(randomNumber).isGreaterThanOrEqualTo(0);
            assertThat(randomNumber).isLessThanOrEqualTo(9);
        }
    }
}

package racingcar.step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step4.config.MoveConfig;
import racingcar.step4.domain.Car;
import racingcar.step4.domain.Cars;
import racingcar.step4.move.Moving;
import racingcar.step4.service.RacingGame;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    Moving moving;

    @BeforeEach
    void init() {
        MoveConfig moveConfig = new MoveConfig();
        moving = moveConfig.move();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("값은 0 이하 값이 들어오면 안된다")
    void inputValidation(int value) {
        assertThatThrownBy(() -> new RacingGame("K3,k5", value, 2))
                .isInstanceOf(IllegalArgumentException.class);
        //값 정상
        assertThatCode(() -> new RacingGame("K3,k5", 1, 2))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("랜덤값 - 레이스 테스트")
    void race() {
        RacingGame racingGame = new RacingGame("K3,k5", 10, 2);
        racingGame.race(moving);
        assertThat(racingGame.getCountOfTry()).isEqualTo(9);
        assertThat(racingGame.isEndGame()).isFalse();
    }

    @Test
    @DisplayName("랜덤값 - 종료 테스트")
    void endGame() {
        RacingGame racingGame = new RacingGame("K3,k5", 10, 2);
        for (int i = 0; i < 10; i++) {
            racingGame.race(moving);
        }
        assertThat(racingGame.isEndGame()).isTrue();
    }

    @Test
    @DisplayName("자동차 이름을 구분자로 쪼개기")
    void nameSplit() {
        String[] arr = {"k3", "k5", "k7"};
        RacingGame racingGame = new RacingGame("k3,k5,k7", 5, 3);
        assertThat(racingGame.getCars().equals(new Cars(arr, 3))).isTrue();
    }

}

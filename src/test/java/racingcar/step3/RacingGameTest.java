package racingcar.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step3.domain.Cars;
import racingcar.step3.move.Moving;
import racingcar.step3.service.RacingGame;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    Moving moving;

    @BeforeEach
    void init() {
        AppConfig appConfig = new AppConfig();
        moving = appConfig.move();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("값은 0 이하 값이 들어오면 안된다")
    void inputValidation(int value) {
        Cars cars = new Cars(3);
        assertThatThrownBy(() -> new RacingGame(value, cars))
                .isInstanceOf(IllegalArgumentException.class);
        //값 정상
        assertThatCode(() -> new RacingGame(1, cars))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("랜덤값 테스트 - 레이스 테스트")
    void race() {
        Cars cars = new Cars(3);
        RacingGame racingGame = new RacingGame(10, cars);
        racingGame.race(moving);
        assertThat(racingGame.getCountOfTry()).isEqualTo(9);
        assertThat(racingGame.isEndGame()).isFalse();
    }

    @Test
    @DisplayName("랜덤값 테스트 - 종료 테스트")
    void endGame() {
        Cars cars = new Cars(3);
        RacingGame racingGame = new RacingGame(10, cars);
        for (int i = 0; i < 10; i++) {
            racingGame.race(moving);
        }
        assertThat(racingGame.isEndGame()).isTrue();
    }

}

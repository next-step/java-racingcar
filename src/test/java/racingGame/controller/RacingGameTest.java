package racingGame.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7})
    @DisplayName("생성자 메소드는 입력된 자동차 대수가 유효할때만, 객체를 생성한다.")
    void 생성자_성공_테스트(final int carCount) {
        assertDoesNotThrow(() -> new RacingGame(carCount, 3));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("생성자 메소드는 입력된 자동차 대수가 유효하지 않으면, 에러를 반환한다.")
    void 생성자_에러_테스트(final int carCount) {
        assertThatThrownBy(() -> new RacingGame(carCount, 3))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    @DisplayName("생성자 메소드는 입력된 자동차 움직임 횟수가 유효할때만, 객체를 생성한다.")
    void 생성자_성공_테스트_2(final int moveCount) {
        assertDoesNotThrow(() -> new RacingGame(2, moveCount));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("생성자 메소드는 입력된 움직임 횟수가 유효하지 않으면, 에러를 반환한다.")
    void 생성자_에러_테스트_2(final int moveCount) {
        assertThatThrownBy(() -> new RacingGame(2, moveCount))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1", "3:4", "2:10"}, delimiter = ':')
    @DisplayName("play 메소드는 입력한 라운드 수만큼, 시도 되어야 한다.")
    public void play_메소드_라운드_횟수_체크_테스트(final int carCount, final int moveCount) {

        RacingGame racingGame = new RacingGame(carCount, moveCount);

        racingGame.play();

        assertThat(racingGame.getRound()).isEqualTo(moveCount);
    }
}

package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {

    // TODO
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {"-5, -1, 0, O, !, @, #, $, zero, one, five, ten"})
    void newGame_invalidCarNo_invalidTryNo(final String invalidNo) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Game(invalidNo, invalidNo))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-5, -1, 0, O, !, @, #, $, zero, one, five, ten"})
    void newGame_invalidCarNo_validTryNo(final String invalidCarNo) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Game(invalidCarNo, "1"))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-5, -1, 0, O, !, @, #, $, zero, one, five, ten"})
    void newGame_validCarNo_invalidTryNo(final String invalidTryNo) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Game("5", invalidTryNo))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    void newGame_validCarNo_validTryNo(final String validNo) {
        assertThatCode(() -> new Game(validNo, validNo))
            .doesNotThrowAnyException();
    }

    @DisplayName("주어진 자동차 대수만큼, 자동차를 생성하여, 자동차 거리를 반환할 수 있어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    void getCarDistances(final String carNo) {
        final Game game = new Game(carNo, "1");
        assertThat(game.getCarDistances()).hasSize(Integer.parseInt(carNo));
    }

    @DisplayName("주어진 시도 횟수만큼 플레이 후, 게임은 끝나야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    void isGameOver(final String tryNo) {
        final Game game = new Game("3", tryNo);
        for (int i = 0; i < Integer.parseInt(tryNo); i++) {
            assertThat(game.isGameOver()).isFalse();
            game.play();
        }
        assertThat(game.isGameOver()).isTrue();
    }

    @DisplayName("주어진 시도 횟수만큼 플레이 할때 마다, 주어진 자동차 대수 만큼의 자동차들은 전진 혹은 멈추어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    void move(final String tryNo) {
        final Game game = new Game("3", tryNo);
        List<Distance> previousCarDistances = game.getCarDistances();
        // 플레이 전, 모든 자동차들의 전진거리는 0이어야 한다.
        assertThat(previousCarDistances)
            .containsExactly(Distance.ZERO, Distance.ZERO, Distance.ZERO);
        for (int i = 0; i < Integer.parseInt(tryNo); i++) {
            game.play();
            final List<Distance> currentCarDistances = game.getCarDistances();
            // 플레이 후, 모든 자동차들의 전진거리는, 전 회차의 전진거리보다 같거야 전진해야 한다.
            assertMove(previousCarDistances, currentCarDistances);
            previousCarDistances = currentCarDistances;
        }
    }

    private static void assertMove(
        final List<Distance> previousDistances,
        final List<Distance> currentDistances
    ) {

        assertThat(previousDistances.size()).isEqualTo(currentDistances.size());

        for (int i = 0; i < currentDistances.size(); i++) {

            final Distance previousDistance = previousDistances.get(i);
            final Distance currentDistance = currentDistances.get(i);

            assertThat(currentDistance).matches((distance) ->
                distance.isGreaterThan(previousDistance) || distance.equals(previousDistance));
        }
    }

}
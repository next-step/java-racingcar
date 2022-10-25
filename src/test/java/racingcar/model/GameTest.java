package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameTest {

    // TODO
    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    @Test
    void newGame_nullCarNames() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Game(null, "5"))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void newGame_emptyCarNames() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Game("", "5"))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @Test
    void newGame_blankCarNames() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Game(" ", "5"))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"with, ", ", with", " , "})
    void newGame_containsBlankCarName(final String carNames) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Game(carNames, "5"))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"with|beth", "with:beth", "with@beth"})
    void newGame_invalidCarNames(final String carNames) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Game(carNames, "5"))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"with", "with, beth", "with,beth"})
    void newGame_validCarNames(final String carNames) {
        assertThatCode(() -> new Game(carNames, "5"))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-5, -1, 0, O, !, @, #, $, zero, one, five, ten"})
    void newGame_invalidTryNo(final String tryNo) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Game("with", tryNo))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    void newGame_validTryNo(final String tryNo) {
        assertThatCode(() -> new Game("with", tryNo))
            .doesNotThrowAnyException();
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

    @DisplayName("주어진 시도 횟수만큼 플레이 할때 마다, 생성한 자동차 개체들의 이름과, 현재 전진 거리 상황을 반환할 수 있어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    void getCarStatuses(final String tryNo) {
        final Game game = new Game("with, beth, foo", tryNo);

        List<CarStatus> previousCarStatuses = game.getCarStatuses();

        // 플레이 전, 모든 자동차들의 전진거리는 0이어야 한다.
        assertThat(previousCarStatuses)
            .containsExactly(
                new CarStatus("with", Distance.ZERO),
                new CarStatus("beth", Distance.ZERO),
                new CarStatus("foo", Distance.ZERO));

        for (int i = 0; i < Integer.parseInt(tryNo); i++) {

            game.play();

            final List<CarStatus> currentCarStatuses = game.getCarStatuses();

            // 플레이 전후로, 모든 자동차들의 이름은 바뀌지 않아야 한다.
            assertThat(mapToName(previousCarStatuses)).isEqualTo(mapToName(currentCarStatuses));
            // 플레이 후, 모든 자동차들의 전진거리는, 전 회차의 전진거리보다 같거야 전진해야 한다.
            assertMove(mapToDistance(previousCarStatuses), mapToDistance(currentCarStatuses));

            previousCarStatuses = currentCarStatuses;
        }
    }

    @DisplayName("주어진 시도 회수 만큼의 플레이가 끝나면, 우승한 자동차의 이름목록을 반환 할 수 있어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    void getWinners(final String tryNo) {
        final Game game = new Game("with, beth, foo", tryNo);

        // 플레이가 끝나기 전엔, 우승한 자동차 이름목록이 비어있어야 한다.
        for (int i = 0; i < Integer.parseInt(tryNo); i++) {
            assertThat(game.getWinners()).hasSize(0);
            game.play();
        }

        // 주어진 시도 회수만큼 플레이가 끝나면, 우승한 자동차 이름 목록을 반활 할 수 있어야 한다.
        assertThat(game.isGameOver())
            .isTrue();
        assertThat(game.getWinners())
            .isNotEmpty();
        assertThat(game.getWinners())
            .containsAnyOf(
                new Winner("with"),
                new Winner("beth"),
                new Winner("foo"));
    }

    private static List<Distance> mapToDistance(final List<CarStatus> carStatuses) {
        return carStatuses.stream()
            .map(CarStatus::getDistance)
            .collect(Collectors.toList());
    }

    private static List<String> mapToName(final List<CarStatus> carStatuses) {
        return carStatuses.stream()
            .map(CarStatus::getName)
            .collect(Collectors.toList());
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
package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Winners;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WinnersTest {
    static Stream<Arguments> winners() {
        return Stream.of(arguments(new Winners(Arrays.asList("pobi", "crong"), 2)));
    }

    @ParameterizedTest
    @DisplayName("현재 우승자들과 같은 position 플레이어 추가하는지 검증")
    @MethodSource(value = "winners")
    void checkNewPlayerRecord_sameAsWinners(Winners winners) {
        int maxPosition = winners.getPosition();
        List<String> winnersExpected = winners.getNames();

        winners.checkPlayerRecord("honux", maxPosition);

        winnersExpected.add("honux");
        assertThat(winners.getPosition()).isEqualTo(maxPosition);
        assertThat(winners.getNames()).isEqualTo(winnersExpected);
    }

    @ParameterizedTest
    @DisplayName("현재 우승자들 보다 더 큰 position 플레이어 추가")
    @MethodSource(value = "winners")
    void checkNewPlayerRecord_higherThanWinners(Winners winners) {
        int newMaxPosition = 3;

        winners.checkPlayerRecord("honux", newMaxPosition);

        assertThat(winners.getPosition()).isEqualTo(newMaxPosition);
        assertThat(winners.getNames()).containsExactly("honux");
    }
}

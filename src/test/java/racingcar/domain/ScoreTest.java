package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.fixture.RacingCarFixture;

class ScoreTest {


    @DisplayName("우승 여부를 판단할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"3,3,true", "5,4,false", "6,5,false", "0,0,true"})
    void isWinner(int maxValue, int value, boolean expected) {
        // given
        Position maxPosition = Position.from(maxValue);
        Score score = new Score(RacingCarFixture.PARTICIPANT_NAME, Position.from(value));

        // when
        boolean winner = score.isWinner(maxPosition);

        // then
        Assertions.assertThat(winner).isEqualTo(expected);
    }
}

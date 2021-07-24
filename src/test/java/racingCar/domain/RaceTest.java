package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RaceTest {

    @DisplayName("자동차 대수, 경기수가 1 이상일때 객체생성")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "5:3", "10:2"}, delimiter = ':')
    void testInput(int carCount, int roundCount) {
        assertThat(new Race(carCount,roundCount)).isInstanceOf(Race.class);
    }

    @DisplayName("자동차 대수가 1대 미만일때 IllegalArgumentException throw")
    @ParameterizedTest
    @CsvSource(value = {"0:5", "-10:10", "-20:15"}, delimiter = ':')
    void testInputNegativeCarsCount(int carCount, int roundCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Race(carCount, roundCount);
        }).withMessageMatching("자동차 대수는 1대 이상이어야 합니다.");
    }

    @DisplayName("라운드가 1경기 미만일때 IllegalArgumentException throw")
    @ParameterizedTest
    @CsvSource(value = {"5:0", "10:-10", "15:-20"}, delimiter = ':')
    void testInputNegativeRoundCount(int carCount, int roundCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Race(carCount, roundCount);
        }).withMessageMatching("라운드는 1라운드 이상이어야 합니다.");
    }

    @DisplayName("원하는 라운드의 결과를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"15:20"}, delimiter = ':')
    void testGetRound(int carCount, int roundCount) {
        Race race = new Race(carCount, roundCount);
        Round round = race.getRoundResult(1);
        assertThat(round).isInstanceOf(Round.class);
        assertThat(round.getCarsSize()).isEqualTo(carCount);
    }

}

package racingCar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RaceTest {

    @DisplayName("자동차 대수, 경기수가 1 이상일때 객체생성")
    @ParameterizedTest
    @CsvSource(value = {"\"강아지,고양이,원숭이\":1", "\"강아지,고양이,원숭이,코끼리,호랑이\":3", "\"강아지,고양이\":2"}, delimiter = ':')
    void testInput(String names, int roundCount) {
        assertThat(new Race(names,roundCount)).isInstanceOf(Race.class);
    }

    @DisplayName("라운드가 1경기 미만일때 IllegalArgumentException throw")
    @ParameterizedTest
    @CsvSource(value = {"\"강아지,고양이,원숭이\":0", "\"강아지,고양이,원숭이,코끼리,호랑이\":-10", "\"강아지,고양이\":-20"}, delimiter = ':')
    void testInputNegativeRoundCount(String names, int roundCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Race(names, roundCount);
        }).withMessageMatching("라운드는 1라운드 이상이어야 합니다.");
    }

    @DisplayName("원하는 라운드의 결과를 가져온다.")
    @ParameterizedTest
    @CsvSource(value = {"\"강아지,고양이,원숭이\":20"}, delimiter = ':')
    void testGetRound(String names, int roundCount) {
        Race race = new Race(names, roundCount);
        Round round = race.getRoundResult(1);
        assertThat(round).isInstanceOf(Round.class);
        assertThat(round.getCarsSize()).isEqualTo(names.split(",").length);
    }

    @DisplayName("참가한 자동차 중에 우승자가 있는지 확인한다.")
    @Test
    void testAnnounceWinners() {
        Race race = new Race("강아지", 10);
        assertThat(race.announceWinners().size() > 0).isTrue();
    }

}

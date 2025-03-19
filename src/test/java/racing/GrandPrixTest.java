package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

class GrandPrixTest {
    private static final Dice luckyDice = new LuckyDice();

    @Test
    @DisplayName("총 라운드 수 를 받아 전체 라운드 수 만큼 play한다")
    void playForTotalRoundCountTest() {
        // given
        int totalRound = 5;
        var grandPrix = new GrandPrix(totalRound, List.of(""), luckyDice);

        // when
        while (!grandPrix.isFinished()) {
            grandPrix.play();
        }

        // then
        Assertions.assertThat(grandPrix.isFinished()).isTrue();
    }

    @Test
    @DisplayName("자동차의 이름들을 입력 받아 Car를 생성해 cars에 추가한다.")
    void createCarsTest() {
        // given
        var names = List.of("pobi", "crong", "honux");

        // when
        var grandPrix = new GrandPrix(5, names, luckyDice);

        // then
        Assertions.assertThat(grandPrix.getCarCount()).isEqualTo(names.size());
    }

    @Test
    @DisplayName("참가자가 1명이면 챔피온은 바로 그 1명이다.")
    void findChampionWhenOneCarTest() {
        // given
        var carName = "pobi";
        var grandPrix = new GrandPrix(5, List.of(carName), luckyDice);
        while (!grandPrix.isFinished()) {
            grandPrix.play();
        }

        // when
        var champions = grandPrix.findChampions();

        // then
        Assertions.assertThat(champions)
                .hasSize(1)
                .containsExactly(carName);
    }

    @Test
    @DisplayName("참가자가 2명이상이고 모두가 같은 위치에 있으면 모두 챔피온이다.")
    void findChampionsAllSamePositionTest() {
        // given
        var carNames = List.of("pobi", "crong", "honux");
        var grandPrix = new GrandPrix(5, carNames, luckyDice);
        while (!grandPrix.isFinished()) {
            grandPrix.play();
        }

        // when
        var champions = grandPrix.findChampions();

        // then
        Assertions.assertThat(champions)
                .hasSize(carNames.size())
                .containsExactlyElementsOf(carNames);
    }
}

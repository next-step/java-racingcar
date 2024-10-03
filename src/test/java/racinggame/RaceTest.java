package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.racingcar.MoveStrategy;
import racinggame.racingcar.Race;
import racinggame.racingcar.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class RaceTest {

    @ParameterizedTest
    @CsvSource({
            "'a,b,c,d,e', 5",
            "'pobi,crong,honux', 3",
    })
    @DisplayName("주어진 자동차 수로 경주를 생성하고 지정된 라운드 수만큼 진행한다")
    void createAndProceedRace(String nameInput, int numberOfRounds) {
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        List<String> names = List.of(nameInput.split(","));
        Race race = Race.create(moveStrategy, names);

        for (int round = 0; round < numberOfRounds; round++) {
            List<Integer> roundResult = race.proceedRounds();
            final int currentRound = round;

            assertThat(roundResult).hasSize(names.size());
            assertThat(roundResult).allSatisfy(position ->
                    assertThat(position).isBetween(0, currentRound + 1)
            );
        }
    }

}

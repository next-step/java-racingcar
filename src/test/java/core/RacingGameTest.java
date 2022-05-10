package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    @Test
    @DisplayName("cars 의 모든 Car 가 moveCount 번 움직여야 한다")
    void moveCarsRandomlyMoveCountTimes() {
        //given
        final int moveCount = 3;
        Cars cars = TestObjectGenerator.generateCars(3);
        RacingGame racingGame = TestObjectGenerator.generateRacingGame();
        List<Integer> expectedPositionHistory = new ArrayList<>();
        for (int i = 0; i < moveCount; i++) {
            expectedPositionHistory.add(i + 1);
        }

        //when
        PositionBoard result = racingGame.play(cars, 3);

        //then
        result.getPositionTable().forEach((id, positionHistory) -> assertThat(positionHistory).isEqualTo(expectedPositionHistory));
    }
}
package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRoundTest {

    @DisplayName("최종 라운드까지 종료되는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:3", "3:5", "3:2", "5:2"}, delimiter = ':')
    public void roundFinishTest(int participantCar, int round) {
        //Given
        GameRound gameRound = new GameRound(participantCar, round);

        //When
        for (int i = 0; i < round; i++) {
            gameRound.roundFinish();
        }

        //Then
        assertThat(gameRound.isAllRoundFinish()).isTrue();
    }
}

package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRoundTest {


    @DisplayName("모든 라운드를 종료 확인 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7})
    public void createGameRoundInstance(int totalRound) {
        //Given
        GameRound gameRound = new GameRound(totalRound);

        //When
        IntStream.range(0, totalRound)
                .forEach(i -> gameRound.roundFinish());


        //Then
        assertThat(gameRound.isAllRoundFinish()).isTrue();
    }
}

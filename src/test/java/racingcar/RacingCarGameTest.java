package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RacingCarGame;
import racingcar.dto.RacingCarGameRequest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarGameTest {

    private RacingCarGameRequest createGameRequest(int totalPlayCount) {
       return new RacingCarGameRequest(totalPlayCount, createSampleCarNames());
    }

    private List<String> createSampleCarNames () {
        return Arrays.asList("a","b","c");
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2:false","5:5:true"}, delimiter = ':')
    @DisplayName("자동차 게임 isDone 메서드를 통해 finalScoreBoard에 정상적으로 추가 되는지 count는 늘어나는지 테스트")
    void play(int totalPlayCount,int actualPlayCount,boolean expected) {
        RacingCarGame game = new RacingCarGame(createGameRequest(totalPlayCount));
        for (int i = 0; i < actualPlayCount; i++) {
            game.play();
        }
        assertThat(game.isDone()).isEqualTo(expected);
        assertThat(game.getFinalScoreBoard().getAllScore().size()).isEqualTo(actualPlayCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:6"}, delimiter = ':')
    @DisplayName("자동차 게임 최초 요청 횟수보다 더 많이 play했을때 exception 발생 테스트")
    void isPlayThrowExceptionWhenPlayMoreThanPlayCount(int totalPlayCount,int actualPlayCount) {
        RacingCarGame game = new RacingCarGame(createGameRequest(totalPlayCount));
        assertThatIllegalStateException().isThrownBy(() -> {
            for (int i = 0; i < actualPlayCount; i++) {
                game.play();
            }
        });
    }


}

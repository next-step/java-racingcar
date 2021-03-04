package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.RacingCarGame;
import racingcar.dto.RacingCarGameRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class RacingCarGameTest {

    @ParameterizedTest
    @CsvSource(value = {"4:2:3:false","5:5:3:true"}, delimiter = ':')
    @DisplayName("자동차 게임 isDone 메서드를 통해 finalScoreBoard에 정상적으로 추가 되는지 count는 늘어나는지 테스트")
    void play(int totalPlayCount,int actualPlayCount,int carNumber,boolean expected) {
        RacingCarGame game = new RacingCarGame(new RacingCarGameRequest(totalPlayCount,carNumber));
        for (int i = 0; i < actualPlayCount; i++) {
            game.play();
        }
        assertThat(game.isDone()).isEqualTo(expected);
        assertThat(game.getFinalScoreBoard().getAllScore().size()).isEqualTo(actualPlayCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:6:3"}, delimiter = ':')
    @DisplayName("자동차 게임 최초 요청 횟수보다 더 많이 play했을때 exception 발생 테스트")
    void isPlayThrowExceptionWhenPlayMoreThanPlayCount(int totalPlayCount,int actualPlayCount,int carNumber) {
        RacingCarGame game = new RacingCarGame(new RacingCarGameRequest(totalPlayCount,carNumber));
        assertThatIllegalStateException().isThrownBy(() -> {
            for (int i = 0; i < actualPlayCount; i++) {
                game.play();
            }
        });
    }


}

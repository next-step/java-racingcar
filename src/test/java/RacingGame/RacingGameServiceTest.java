package RacingGame;

import RacingGame.service.RacingGameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameServiceTest {
    @Test
    @DisplayName("입력값들이 (,) 구분되어야 한다.")
    void sperateInputNames() {
        //given
        String Input = "황제원,angyu,고다혜";
        RacingGameService racingGameService = new RacingGameService();

        //when
        List<String> expected = List.of(Input.split(","));
        List<String> result = racingGameService.splitCarNames(Input);

        //then
        assertThat(result).containsExactlyElementsOf(expected);
    }
}

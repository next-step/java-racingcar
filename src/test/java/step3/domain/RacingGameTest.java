package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import step3.dto.InputDTO;
import step3.dto.OutputDTO;
import step3.view.ResultView;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameTest {

    @Test
    void service() {
        InputDTO inputDTO = new InputDTO(new String[] {"aa", "bb", "cc"} , 5, 4);
        RacingGame racingGame = new RacingGame();
        OutputDTO outputDTO = racingGame.service(inputDTO);
        new ResultView().printWinner(outputDTO.getWinners());

        Assertions.assertThat(outputDTO.getWinners()).containsAnyOf("aa", "bb", "cc");
    }
}
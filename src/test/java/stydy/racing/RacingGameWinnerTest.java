package stydy.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import study.racing.controller.RacingGame;
import study.racing.controller.RacingGameWinner;
import study.racing.service.RacingGameWinnerService;
import study.utils.NumberUtils;
import study.validation.InputValidation;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameWinnerTest {

   @Test
   @DisplayName("자동차 경주가 잘 출력되는지 확인")
   public void racing() {
       RacingGameWinner racingGameWinner = new RacingGameWinner();
       racingGameWinner.racing();
   }
}

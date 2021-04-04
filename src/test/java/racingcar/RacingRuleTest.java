package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.input.InputView;
import racingcar.racing.RacingRule;

public class RacingRuleTest {

  @ParameterizedTest
  @ValueSource(strings = {"3 4"})
  public void racingRuleInputTest(String str) throws Exception {
    InputView inputView = new InputView(new Scanner(new ByteArrayInputStream(str.getBytes())));
    RacingRule racingRule = inputView.requireRacingRule();
    int carNum = Integer.parseInt(str.split(" ")[0]);
    int tryNum = Integer.parseInt(str.split(" ")[1]);
    assertThat(racingRule.getCarCount()).isEqualTo(carNum);
    assertThat(racingRule.getTryCount()).isEqualTo(tryNum);
  }
}

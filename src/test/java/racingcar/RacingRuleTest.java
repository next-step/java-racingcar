package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.input.InputView;
import racingcar.racing.RacingRule;

public class RacingRuleTest {

  @ParameterizedTest
  @ValueSource(strings = {"poby,drain,win 4"})
  public void racingRuleInputTest(String str) {
    String[] input = str.split(" ");
    List<String> carList = Arrays.asList(input[0].split(InputView.CAR_NAME_SEPARATOR));
    int tryNum = Integer.parseInt(input[1]);

    RacingRule racingRule = new RacingRule(carList, tryNum);

    assertThat(racingRule.getCarCount()).isEqualTo(carList.size());
    assertThat(racingRule.getCarNameList()).containsAll(Arrays.asList("poby", "drain", "win"));
    assertThat(racingRule.getTryCount()).isEqualTo(tryNum);
  }
}

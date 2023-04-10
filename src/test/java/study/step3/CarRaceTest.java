package study.step3;

import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRaceTest {

  @Test
  public void 인풋_테스트() throws Exception {
    // given
    Input input = new InputTestImpl();
    CarRace carRace = new CarRaceImpl(input);

    // when
    String result = carRace.run();
    // then
    System.out.println(result);
  }

  private class InputTestImpl implements Input {

    @Override
    public int getInput(String answer) {
      Random random = new Random();
      int randomValue = random.nextInt(9) + 1;
      System.out.println(answer);
      System.out.println(randomValue);
      return randomValue;
    }
  }
}

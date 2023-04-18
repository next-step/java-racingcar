package study.carrace;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.input.Input;
import study.util.Randomizer;
import study.util.RandomizerImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRaceTest {

  @Test
  public void 인풋_테스트() throws Exception {
    // given
    Input input = new InputTestImpl();
    Randomizer randomizer = new RandomizerImpl();
    CarRace carRace = new CarRaceImpl(input, randomizer);

    // when
    String result = carRace.run();
    // then
    System.out.println(result);
  }

  @Test
  @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
  public void 랜덤_테스트_Over() throws Exception {
    Race race = new Race(new RandomTestOverNumber());
    race.progress();
    String result = race.currentRace(1);
    assertThat(result).isEqualTo("-");
  }

  @Test
  @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
  public void 랜덤_테스트_Under() throws Exception {
    Race race = new Race(new RandomTestUnderNumber());
    race.progress();
    String result = race.currentRace(1);
    assertThat(result).isEqualTo("");
  }

  @Test
  @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
  public void 랜덤_테스트_Bound() throws Exception {
    Race race = new Race(new RandomTestBoundNumber());
    race.progress();
    String result = race.currentRace(1);
    assertThat(result).isEqualTo("-");
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

  private class RandomTestOverNumber implements Randomizer {

    @Override
    public int getRandomValue(int limit) {
      return 5;
    }
  }

  private class RandomTestUnderNumber implements Randomizer {

    @Override
    public int getRandomValue(int limit) {
      return 2;
    }
  }

  private class RandomTestBoundNumber implements Randomizer {

    @Override
    public int getRandomValue(int limit) {
      return 4;
    }
  }
}

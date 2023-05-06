package study.carrace;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.car.Car;
import study.dto.InputDto;
import study.util.Input;
import study.util.Randomizer;
import study.util.RandomizerImpl;
import study.util.Result;
import study.util.ResultImpl;
import study.view.InputView;
import study.view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRaceTest {

  @Test
  public void 인풋_테스트() throws Exception {
    // given
    Input carInput = new InputCarStringTest();
    Input countInput = new InputTestImpl();
    InputView inputView = new InputView(carInput, countInput);

    Randomizer randomizer = new RandomizerImpl();
    Result result = new ResultImpl();

    CarRace carRace = new CarRaceImpl(randomizer);
    OutputView outputView = new OutputView(result);
    // when
    carRace.run(inputView, outputView);
  }

  @Test
  @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
  public void 랜덤_테스트_Over() throws Exception {
    Race race = new Race(new RandomTestOverNumber(), new Car("test"));
    race.progress();
    String result = race.currentRace(1);
    assertThat(result).isEqualTo("test : -");
  }

  @Test
  @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
  public void 랜덤_테스트_Under() throws Exception {
    Race race = new Race(new RandomTestUnderNumber(), new Car("test"));
    race.progress();
    String result = race.currentRace(1);
    assertThat(result).isEqualTo("test : ");
  }

  @Test
  @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
  public void 랜덤_테스트_Bound() throws Exception {
    Race race = new Race(new RandomTestBoundNumber(), new Car("test"));
    race.progress();
    String result = race.currentRace(1);
    assertThat(result).isEqualTo("test : -");
  }

  @Test
  @DisplayName("최종우승자를 출력하자.")
  public void 최종우승자출력() throws Exception {
    // given
    Input carInput = new InputCarStringTest();
    Input countInput = new InputTestImpl();
    InputView inputView = new InputView(carInput, countInput);
    Randomizer randomizer = new RandomizerImpl();

    // when
    InputDto inputDto = inputView.view();
    Car[] cars = Car.createCarsAsStr(inputDto.getCarsStr());
    RaceGame raceGame = new RaceGameImpl(cars, inputDto.getTryCount(), randomizer);
    RaceList raceList = raceGame.process();

    // then
    assertThat(raceList.winner()).isNotEmpty();
  }

  private class InputCarStringTest implements Input {

    @Override
    public String getInput(String answer) {
      return "car1,car2,car3,car4,car5";
    }
  }

  private class InputTestImpl implements Input {

    @Override
    public String getInput(String answer) {
      Random random = new Random();
      int randomValue = random.nextInt(9) + 1;
      System.out.println(answer);
      System.out.println(randomValue);
      return randomValue + "";
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

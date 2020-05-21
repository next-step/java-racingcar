package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.util.RandomUtil;
import racingcar.view.ResultView;

@DisplayName("자동차 경주의 핵심 로직을 테스트한다.")
public class RacingCarTest {

  GameController gameController;

  @BeforeEach
  void setUp() {
    int attemptNum = 3;
    String line = "honux, pobi, crong";
    String[] names = line.split(", ");
    gameController = GameController.create(attemptNum, names);
  }


  @Test
  void 랜덤값이_0과_9_사이이다() {
    assertThat(RandomUtil.getRandomValue()).isBetween(0, 9);
  }

  @Test
  void 랜덤값이_4이상일때_전진한다() {

    //given
    Car car1 = Car.create("first car");
    int previousPositionOfCar1 = car1.getPosition();
    Car car2 = Car.create("second car");
    Car car3 = Car.create("third car");
    Car car4 = Car.create("fourth car");
    Car car5 = Car.create("fifth car");

    List<Car> carList = new ArrayList<>();
    carList.add(car1);
    carList.add(car2);
    carList.add(car3);
    carList.add(car4);
    carList.add(car5);

    Game game = Game.create(carList);

    //when
    assertThat(game.doRace().get(0).getPosition())
        //then
        .isEqualTo(previousPositionOfCar1);

    //when
    assertThat(game.doRace().get(0).getPosition())
        //then
        .isGreaterThan(previousPositionOfCar1);
  }

  @Test
  void 입력한_대수만큼_자동차가_생성된다() {
    int carNum = 4;
    assertThat(gameController.getGame().getCars().size()).isEqualTo(carNum);
  }

  @Test
  void 입력한_횟수만큼_자동차가_경주된다() {
    int attemptNum = 3;
    assertThat(gameController.proceedGame().getRaceNum()).isEqualTo(attemptNum);
  }

  @Test
  void 입력된_횟수만큼_자동차가_표시된다() {
    Game game = gameController.proceedGame();
    ResultView resultView = gameController.getResults();
    assertThat(game.getCars()
        .stream()
        .map(Car::getPosition))
        .isEqualTo(resultView.getResultListSize());
  }

  @Test
  void 자동차마다_생성되는_레이싱_수가_다르다() {
    Game game = gameController.proceedGame();
    IntStream.range(0, game.getCars().size() - 1).forEach(i -> {
      assertThat(game.getCars().get(i).getPosition())
          .isNotEqualTo(game.getCars().get(i + 1).getPosition());
    });
  }

  @Test
  void 입력한_이름이_자동차_이름이_된다() {
    assertThat(gameController.getGame().getCars().get(0).getName()).isEqualTo("honux");
    assertThat(gameController.getGame().getCars().get(1).getName()).isEqualTo("pobi");
    assertThat(gameController.getGame().getCars().get(2).getName()).isEqualTo("crong");
  }
}

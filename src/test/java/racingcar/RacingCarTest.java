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
import racingcar.domain.Cars;
import racingcar.domain.CarsMock;
import racingcar.domain.Game;
import racingcar.domain.GameMock;
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
    Cars cars = Cars.create(names);
    Game game = Game.create(cars);
    gameController = GameController.create(attemptNum, game);
  }


  @Test
  void 랜덤값이_0과_9_사이이다() {
    assertThat(RandomUtil.getRandomValue()).isBetween(0, 9);
  }

  @Test
  void 랜덤값이_4이상일때_전진한다() {
    //given
    int NON_UPDATE_THRESHOLD = 3;
    int UPDATE_THRESHOLD = 4;
    String[] names = {"pobi", "crong", "honux"};
    Cars cars = Cars.create(names);
    int previousPositionOfCar1 = cars.getCars().get(0).getPosition();

    //when
    assertThat(cars.getCars().get(0).updatePosition(NON_UPDATE_THRESHOLD))
        //then
        .isEqualTo(previousPositionOfCar1);

    //when
    assertThat(cars.getCars().get(0).updatePosition(UPDATE_THRESHOLD))
        //then
        .isGreaterThan(previousPositionOfCar1);
  }

  @Test
  void 입력한_횟수만큼_자동차가_경주된다() {

    //given
    int attemptNum = 4;
    String[] names = {"pobi", "crong", "honux"};
    Cars cars = Cars.create(names);
    GameMock gameMock = GameMock.create(cars);
    GameController gameController = GameController.create(attemptNum, gameMock);

    //when
    gameController.proceedGame();

    //then
    assertThat(gameMock.getAttemptNum()).isEqualTo(attemptNum);
  }

  @Test
  void 자동차의_전진수만큼_하이픈이_출력된다() {
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

  @Test
  void 우승자가_한_명일때_정상적으로_출력된다() {

    //given
    Car car1 = Car.create("honux");
    car1.updatePosition(4);
    Car car2 = Car.create("crong");
    car2.updatePosition(3);
    Car car3 = Car.create("pobi");
    car3.updatePosition(3);

    List<Car> carList = new ArrayList<>();
    carList.add(car1);
    carList.add(car2);
    carList.add(car3);

    CarsMock cars = CarsMock.create(carList);

    //when
    GameMock gameOne = GameMock.create(cars);
    ResultView resultViewForOne = ResultView.create(gameOne);

    //then
    assertThat(resultViewForOne.winnerView(carList).size()).isEqualTo(1);
    assertThat(resultViewForOne.winnerView(carList).get(0).getName()).isEqualTo("honux");
  }

  @Test
  void 우승자가_두_명일때_정상적으로_출력된다() {

    //given
    Car car1 = Car.create("honux");
    car1.updatePosition(8);
    Car car2 = Car.create("crong");
    car2.updatePosition(8);
    Car car3 = Car.create("pobi");
    car3.updatePosition(3);

    List<Car> carList = new ArrayList<>();
    carList.add(car1);
    carList.add(car2);
    carList.add(car3);

    CarsMock cars = CarsMock.create(carList);

    //when
    Game gameOne = Game.create(cars);
    ResultView resultViewForOne = ResultView.create(gameOne);

    //then
    assertThat(resultViewForOne.winnerView(carList).size()).isEqualTo(2);
    assertThat(resultViewForOne.winnerView(carList).get(0).getName()).isEqualTo("honux");
    assertThat(resultViewForOne.winnerView(carList).get(1).getName()).isEqualTo("crong");
  }
}

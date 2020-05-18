package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.util.RandomUtil;

@DisplayName("자동차 경주의 핵심 로직을 테스트한다.")
public class RacingCarTest {

  List<Car> carList;

  @BeforeEach
  void setUp() {
    //given
    Car car1 = Car.create("first car");
    Car car2 = Car.create("second car");
    Car car3 = Car.create("third car");
    Car car4 = Car.create("fourth car");
    Car car5 = Car.create("fifth car");

    carList = new ArrayList<>();
    carList.add(car1);
    carList.add(car2);
    carList.add(car3);
    carList.add(car4);
    carList.add(car5);
  }

  @Test
  void 랜덤값이_0과_9_사이이다() {
    assertThat(RandomUtil.getRandomValue()).isBetween(0, 9);
  }

  @Test
  void 랜덤값이_4이상일때_전진한다() {

    //game에 들어간 객체 내부 리스트는 독립적이지 않나? 외부 리스트가 변동되면 내부 리스트도 바뀐다.
    //아마 stream 때문인 듯
    //이게 pass by reference라는 건가??
    //https://stackoverflow.com/questions/27635637/java-no-arraylist-modifications-from-outside-classes
    //https://stackoverflow.com/questions/47177561/java-list-changed-when-update-another-one
    Game game = Game.create(carList);

    //when
    game.doRace(4);
//    assertThat(game.getCars().get(0).getPosition()).isGreaterThan(car1.getPosition());

//    assertThat(game.doRace(3)et(0).getPosition())
//        //then
//        .isEqualTo(car1.getPosition());
//
//    //when
//    assertThat(game.doRace(4).get(0).getPosition())
//        //then
//        .isGreaterThan(car1.getPosition());
  }
}

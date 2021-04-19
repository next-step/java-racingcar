package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.CarFactory;
import study.step3.domain.Cars;
import study.step3.domain.GameRound;
import study.step3.domain.Record;

public class RecordTest {

  @DisplayName("반복 횟수를 입력하고 record 객체 생성 테스트")
  @Test
  void createRecord() {
    // given
    int times = 4;

    // when
    Record record = new Record(times);

    // then
    assertThat(record).isNotNull();
  }

  @DisplayName("자동차 이름과 반복 횟수를 입력하고 우승자 찾는지 테스트")
  @Test
  void findWinners() {
    // given
    int times = 4;
    String[] names = new String[]{"pobi", "crong", "honux"};
    Cars cars = CarFactory.makeCars(names);
    Record record = new Record(times);
    GameRound gameRound = new GameRound(times);

    // when
    while (!gameRound.isEnd()) {
      gameRound.reduceRound();
      cars.move();
    }

    String winners = record.findWinners(cars.getCars());

    // then
    assertThat(Arrays.stream(names).anyMatch(winners::equals)).isTrue();
  }

}

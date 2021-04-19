package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.Car;
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
    List<Car> carList = Arrays.asList(new Car(4, names[0]), new Car(3, names[1]));
    Record record = new Record(times);

    // when
    String winners = record.findWinners(carList);

    // then
    assertThat(winners).isEqualTo(names[0]);
  }

  @DisplayName("자동차 이름과 반복횟수를 입력하고 완주를 못했을 때, 우승자를 못찾는지 테스트")
  @Test
  void findWinnersFail() {
    // given
    int times = 4;
    String[] names = new String[]{"pobi", "crong", "honux"};
    List<Car> carList = Arrays.asList(new Car(0, names[0]), new Car(3, names[1]));
    Record record = new Record(times);

    // when
    String winners = record.findWinners(carList);

    // then
    assertThat("".equals(winners)).isTrue();
  }

}

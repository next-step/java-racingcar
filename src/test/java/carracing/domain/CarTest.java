package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

class CarTest {

  private Car car;

  private static final int TRY_INIT_COUNT = 10;

  @BeforeEach
  void init() {
    car = new Car(TRY_INIT_COUNT);
  }

  @ParameterizedTest
  @DisplayName("car의 생성자를 통해 입력한 현재위치와 시도 횟수 초기화가 이루어지는지 확인한다.")
  @CsvSource(value = {"1:10", "1:8", "1:7"}, delimiter = ':')
  void createCar(int now, int tryCount) {
    car = new Car(tryCount);
    assertThat(car.getNowStep()).isEqualTo(now);
    assertThat(car.getMoveCount()).isEqualTo(tryCount);
  }

  @ParameterizedTest
  @DisplayName("car의 step 증가 요청을 보냈을 떄 현재 step에서 +1이 되는지 확인한다.")
  @CsvSource(value = {"5:5", "10:10", "16:16"}, delimiter = ':')
  void plusNowStep(int input, int result) {
    for (int i = 0; i < input; i++) {
      car.plusNowStep();
    }
    assertThat(car.getNowStep()).isEqualTo(result);
  }

  @ParameterizedTest
  @CsvSource(value = {"10:0", "5:5", "6:4"}, delimiter = ':')
  void minusMoveCount(int input, int result) {
    for (int i = 0; i < input; i++) {
      car.minusMoveCount();
    }
    assertThat(car.getMoveCount()).isEqualTo(result);
  }

  @ParameterizedTest
  @DisplayName("도전 기회가 0이하 일때 기회를 소진하는 함수 호출 시 IllegalStateException을 던진다.")
  @ValueSource(ints = {-1, 0, -5, -21})
  void NoMoreChanceTest(int input) {
    car = new Car(input);
    assertThatIllegalStateException().isThrownBy(() -> car.minusMoveCount());
  }

  @ParameterizedTest
  @DisplayName("한칸씩 전진이 가능하므로 주어진 기회 이상 이동을 시도할 때 IllegalStateException을 던진다.")
  @ValueSource(ints = {5, 10, 15})
  void NoMoreMoveTest(int tryCount) {
    car = new Car(tryCount);
    for (int i = 0; i < tryCount; i++) {
      car.plusNowStep();
    }
    assertThatIllegalStateException().isThrownBy(() -> car.plusNowStep());
  }
}
package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

  @DisplayName("차를 이동시키고 위치에 따른 콘솔 출력 형태의 문자열을 요구하면 반환한다.")
  @ParameterizedTest
  @CsvSource(value = {
      "0:''",
      "1:-",
      "2:--",
      "7:-------",
  }, delimiter = ':')
  void getLocationConsoleFormat_returnsConsolePrintFormat(int goCount, String consoleOutput) {
    Car car = new Car();

    for (int i = 0; i < goCount; i++) {
      car.go();
    }

    assertThat(car.getLocationConsoleFormat()).isEqualTo(consoleOutput);
  }
}

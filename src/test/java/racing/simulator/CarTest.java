package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
  @DisplayName("위치에 따른 콘솔 출력 형태의 스트링을 요구하면 반환한다.")
  @ParameterizedTest
  @CsvSource(value = {
      "1:-",
      "2:--",
      "7:-------",
  }, delimiter = ':')
  void getLocationConsoleFormat_returnsConsolePrintFormat(String goCount, String consoleOutput) {
    Car car = new Car();
    int goCountNum = Integer.parseInt(goCount);

    for (int i = 0; i <= goCountNum; i++) {
      car.go();
    }

    assertThat(car.getLocationConsoleFormat()).isEqualTo(consoleOutput);
  }
}

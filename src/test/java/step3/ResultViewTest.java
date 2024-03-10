package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import testutils.IOTest;

import java.io.ByteArrayOutputStream;

public class ResultViewTest extends IOTest {
  @Test
  void 자동차들의_현재_위치를_출력() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    setOutputStream(outputStream);
    CarRepository carRepository = new CarRepository();
    carRepository.addCar(new Car());
    carRepository.addCar(new Car(1));
    carRepository.addCar(new Car(3));

    ResultView.printCurrentStatus(carRepository);

    Assertions.assertThat(outputStream.toString()).isEqualTo("\r\n-\r\n---\r\n\r\n");
  }
}

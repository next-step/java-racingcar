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
    carRepository.addCar(new Car("test1", 3));
    carRepository.addCar(new Car("test2", 2));
    carRepository.addCar(new Car("test3",5));

    ResultView.printCurrentStatus(carRepository);

    Assertions.assertThat(outputStream.toString()).isEqualTo("test1 : ---\r\ntest2 : --\r\ntest3 : -----\r\n\r\n");
  }
}

package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import testutils.IOTest;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ResultViewTest extends IOTest {
  @Test
  void 자동차들의_현재_위치를_출력() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    setOutputStream(outputStream);
    Cars cars = new Cars();
    cars.addCar(new Car("test1", 3));
    cars.addCar(new Car("test2", 2));
    cars.addCar(new Car("test3",5));

    ResultView.printCurrentStatus(cars);

    Assertions.assertThat(outputStream.toString()).isEqualTo("test1 : ---\r\ntest2 : --\r\ntest3 : -----\r\n\r\n");
  }

  @Test
  void 우승자_출력() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    setOutputStream(outputStream);

    List<Car> cars = new ArrayList<>();
    cars.add(new Car("test1"));
    cars.add(new Car("test2"));

    ResultView.printWinners(cars);

    Assertions.assertThat(outputStream.toString()).isEqualTo("test1, test2가 최종 우승했습니다.\r\n");
  }
}

package step4.carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ResultViewTest {

  @DisplayName("매 회마다 자동차들의 위치를 출력하는 기능 테스트")
  @Test
  void testPrintCarPosition() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    Car car = CarFactory.createCar("pobi");
    car.move(4);
    car.move(4);
    car.move(1);
    String expected = "pobi : " + "---\n";

    ResultView.printCarStatus(car);

    System.setOut(originalOut);
    Assertions.assertEquals(expected, outputStream.toString());
  }
}
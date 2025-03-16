package carracing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ResultViewTest {

  @DisplayName("자동차의 상태를 출력하는 기능 테스트")
  @Test
  void testPrintCarStatus() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    Car testCar = new Car();
    testCar.move(4);
    testCar.move(5);
    testCar.move(3);
    ResultView.printCarStatus(testCar);

    System.setOut(originalOut);
    String expectedOutput = "---\n";
    Assertions.assertEquals(expectedOutput, outputStream.toString());
  }
}
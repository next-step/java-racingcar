package step4.carracing.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.carracing.RandomCarMoveStrategy;
import step4.carracing.domain.Car;
import step4.carracing.domain.Cars;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class ResultViewTest {

  @DisplayName("매 회마다 자동차들의 위치를 출력하는 기능 테스트")
  @Test
  void testPrintCarPosition() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    Cars cars = new Cars(
            List.of(
                    new Car(3, "pobi", new RandomCarMoveStrategy())
            )
    );
    String expected = "pobi : " + "----\n\n";

    ResultView.printCarStatus(cars);

    System.setOut(originalOut);
    Assertions.assertEquals(expected, outputStream.toString());
  }
}
package racing.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.core.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ResultView resultView = new ResultView();

    @BeforeEach
    void setUpStream(){
        System.setOut(new PrintStream(outContent));
    }

    @Test
    @DisplayName("첫 메세지를 정상적으로 출력하는지 확인")
    void testCorrectFirstText(){
        resultView.printStartText();

        assertThat(outContent.toString()).isEqualTo("\n실행 결과\n");
    }

    @Test
    @DisplayName("CarList가 주어졌을 때 정상적인 출력값 확인")
    void testPrintedTextWithCarList(){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(2));
        carList.add(new Car(3));
        carList.add(new Car(4));
        resultView.printCarList(carList);

        assertThat(outContent.toString()).isEqualTo("---\n----\n-----\n\n");
    }

}

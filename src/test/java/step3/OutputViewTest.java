package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.Calculator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void printNumberTest() {
        System.out.println("1");
        assertEquals("1\r\n", outContent.toString());
    }

    @Test
    public void printNumberOfCarsTest() {
        OutputView.printNumberOfCars();
        assertEquals("자동차 대수는 몇 대 인가요?\r\n", outContent.toString());
    }

    @Test
    public void printNumberOfRoundsTest() {
        OutputView.printNumberOfRounds();
        assertEquals("시도할 회수는 몇 회 인가요?\r\n", outContent.toString());
    }

    @Test
    public void printExecutionResultsTest() {
        OutputView.printExecutionResults();
        assertEquals("실행 결과\r\n", outContent.toString());
    }

    @Test
    public void printDashTest() {
        OutputView.printDash();
        assertEquals("-", outContent.toString());
    }

    @Test
    public void printCarDistanceTest() {
        OutputView.printCarDistance(3);
        assertEquals("---", outContent.toString());
    }

    @Test
    public void printCarRacingTest() {
        Cars cars = new Cars(3, new TestMoveStrategy());
        cars.move();
        OutputView.printCarRacing(cars);
        assertEquals("-\r\n-\r\n-\r\n\r\n", outContent.toString());
    }

    @ParameterizedTest(name = "{0}라운드")
    @CsvSource(value = {"1:'-\r\n-\r\n-\r\n\r\n'", "2:'--\r\n--\r\n--\r\n\r\n'", "3:'---\r\n---\r\n---\r\n\r\n'"}, delimiter = ':')
    public void printCarRacing2Test(String roundString, String expected) {
        Cars cars = new Cars(3, new TestMoveStrategy());
        int round = Integer.parseInt(roundString);
        for(int i = 0; i < round; i++){
            cars.move();
        }
        OutputView.printCarRacing(cars);
        assertEquals(expected, outContent.toString());
    }


}

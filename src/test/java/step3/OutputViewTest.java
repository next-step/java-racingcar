package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        assertEquals("1", outContent.toString().trim());
    }

    @Test
    public void printNumberOfCarsTest() {
        System.out.println(CarRacingConstant.NUMBER_OF_CARS);
        assertEquals("자동차 대수는 몇 대 인가요?", outContent.toString().trim());
    }

    @Test
    public void printNumberOfRoundsTest() {
        System.out.println(CarRacingConstant.NUMBER_OF_ROUNDS);
        assertEquals("시도할 회수는 몇 회 인가요?", outContent.toString().trim());
    }

    @Test
    public void printExecutionResults() {
        System.out.println(CarRacingConstant.EXECUTION_RESULTS);
        assertEquals("실행 결과", outContent.toString().trim());
    }

    @Test
    public void printDash() {
        System.out.println(CarRacingConstant.DASH);
        assertEquals("-", outContent.toString().trim());
    }

}

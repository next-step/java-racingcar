import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.RaceView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RaceViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void queryNumberOfCarsTest() {
        int numberOfCars = 3;

        var scannerMock = Mockito.mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(numberOfCars);

        var raceView = new RaceView(scannerMock);
        var result = raceView.queryAndGetNumberOfCars();
        var consoleOutput = outputStream.toString();

        assertThat(consoleOutput).isEqualTo("자동차 대수는 몇 대 인가요?\n");
        assertThat(result).isEqualTo(numberOfCars);
    }

    @Test
    public void queryRaceStepsTest() {
        int steps = 5;

        var scannerMock = Mockito.mock(Scanner.class);
        when(scannerMock.nextInt()).thenReturn(steps);

        var raceView = new RaceView(scannerMock);
        var result = raceView.queryAndGetSteps();
        var consoleOutput = outputStream.toString();

        assertThat(consoleOutput).isEqualTo("시도할 회수는 몇 회 인가요?\n");
        assertThat(result).isEqualTo(steps);
    }

    @Test
    public void printRaceStatus() {
        var carPositions = List.of(2, 1, 2);

        var defaultScanner = new Scanner(System.in);
        var raceView = new RaceView(defaultScanner);
        raceView.printCurrentRaceStatus(carPositions);

        var result = outputStream.toString();
        var expected = "---\n" +
                "--\n" +
                "---\n" +
                "\n";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void printRaceResultTitle() {
        var defaultScanner = new Scanner(System.in);
        var raceView = new RaceView(defaultScanner);

        raceView.printResultTitle();

        var result = outputStream.toString();
        var expected = "실행 결과\n";
        assertThat(result).isEqualTo(expected);
    }
}

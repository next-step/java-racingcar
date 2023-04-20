import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import view.RaceView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RaceViewTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void queryNamesOfCarsTest() {
        var carsInput = "pobi,crong,honux";

        var scannerMock = Mockito.mock(Scanner.class);
        when(scannerMock.nextLine()).thenReturn(carsInput);

        var raceView = new RaceView(scannerMock);
        var result = raceView.queryAndGetNamesOfCars();
        var consoleOutput = outputStream.toString();

        assertThat(consoleOutput).isEqualTo("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n");
        assertThat(result).containsExactly("pobi", "crong", "honux");
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
        var carPositions = Map.of(
                "pobi", 3,
                "crong", 5,
                "honux", 2
        );

        var defaultScanner = new Scanner(System.in);
        var raceView = new RaceView(defaultScanner);
        raceView.printCurrentRaceStatus(carPositions);

        var result = outputStream.toString();
        var expectedLines = Set.of(
                "pobi : ----\n",
                "crong : ------\n",
                "honux : ---\n",
                "\n"
        );
        assertThat(result).contains(expectedLines);
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

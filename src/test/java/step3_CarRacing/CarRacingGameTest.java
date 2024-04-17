package step3_CarRacing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.*;


class CarRacingGameTest {
    private final InputStream stdIn = System.in;
    private final PrintStream stdOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpPrintStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreSystemIn() {
        System.setIn(stdIn);
        System.setOut(stdOut);
    }

    @ParameterizedTest
    @CsvSource({
            "2,3,9",
            "2,4,12",
            "3,1,4",
            "3,2,8",
            "12,1234,16042",
            "100,1,101",
            "100,2,202",
            "100,50,5050",
            "100,73,7373",
            "8562,1,8563",
    })
    @DisplayName("csvSource로 부터 받은 데이터와 예상메시지가 일치해야 한다.")
    public void MainOutputTest(String expectedCars, String expectedTries, long expectedLines) {
        // GIVEN
        provideInput(expectedCars, expectedTries);

        // WHEN
        CarRacingGame.main(new String[]{});

        // THEN
        String outputStreamCaptorString = outContent.toString();
        String raceResult = outputStreamCaptorString.split("\n실행 결과\n", 2)[1];

        long linesCount = raceResult.lines().count();
        assertThat(linesCount).isEqualTo(expectedLines);

        long emptyLinesCount = raceResult.lines().filter(String::isEmpty).count();
        assertThat(emptyLinesCount).isEqualTo(Long.parseLong(expectedTries));
    }

    private void provideInput(String... strings) {
        String inputStr = String.join("\n", strings);
        System.setIn(new ByteArrayInputStream(inputStr.getBytes(UTF_8)));
    }

    @Test
    @DisplayName("value4가 4이상이면 움직이고 그러지 않으면 움직이지 않는다.")
    void CarMoveTest() {
        Car car = new Car();
        car.move(4); // 무조건 움직임
        assertThat(car.getDistance()).isEqualTo(2);
        car.move(3); // 무조건 안움직임
        assertThat(car.getDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName("100개의 차가 참가한 race가 일단 열리면, 100대중 1개는 전진 한다")
    public void RaceRoundTest() {
        Race race = new Race(100);
        race.runRound();
        boolean anyCarMoved = race.getCars().stream().anyMatch(car -> car.getDistance() > 1);
        assertThat(anyCarMoved).isTrue();
    }
}
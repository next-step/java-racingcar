package step3_CarRacing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @AfterEach
    void restoreSystemIn() {
        System.setIn(stdIn);
        System.setOut(stdOut);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "3, 5, '자동차 대수: 3, 시도할 회수: 5'",
            "7, 8, '자동차 대수: 7, 시도할 회수: 8'",
            "11, 22, '자동차 대수: 11, 시도할 회수: 22'",
            "59, 7, '자동차 대수: 59, 시도할 회수: 7'"
    })
    @DisplayName("csvSource로 부터 받은 데이터와 예상메시지가 일치해야 한다.")
    public void givenCsvSourceData_whenComparedToExpectedMessage_shouldMatchExactly(
            String expectedCars, String expectedTries, String expectedOutput) {
        // GIVEN
        provideInput(expectedCars, expectedTries);
        ByteArrayOutputStream outputStreamCaptor = provideOutput();
        // WHEN
        CarRacingGame.main(new String[]{});

        // THEN
        assertThat(outputStreamCaptor.toString()).contains(expectedOutput);
    }

    private void provideInput(String... strings) {
        String inputStr = String.join("\n", strings);
        System.setIn(new ByteArrayInputStream(inputStr.getBytes(UTF_8)));
    }

    private ByteArrayOutputStream provideOutput() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        return byteArrayOutputStream;
    }

    @Test
    void CarMoveTest(){
        Car car = new Car();
        car.move(4); // 무조건 움직임
        assertThat(car.getDistance()).isEqualTo(2);
    }

}
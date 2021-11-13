package racing.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Car;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("3단계 - 자동차 경주 - TerminalOutputView 단위 테스트")
class TerminalOutputViewTest {

    PrintStream stdout = System.out;
    OutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(stdout);
    }

    @Test
    @DisplayName("자동차 상태 출력 기능")
    void printCars() {
        List<Car> cars = Arrays.asList(new Car(), new Car());
        int numberOfMove = 3;

        TerminalOutputView.printStartSentence();
        for (int i = 0; i < numberOfMove; i++) {
            cars.forEach(Car::moveRandom);
            TerminalOutputView.printCars(cars);
        }

        String[] lines = outputStream.toString()
                .split(System.lineSeparator());
        assertThat(lines.length)
                .isEqualTo((cars.size() + 1) * numberOfMove);
    }
}
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

import static java.lang.System.lineSeparator;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 - TerminalOutputView 단위 테스트")
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
        List<Car> cars = createMockCars();
        int numberOfMove = 3;

        printTerminalOutput(cars, numberOfMove);

        String[] lines = outputStream.toString()
                .split(lineSeparator());
        assertThat(lines.length)
                .isEqualTo((cars.size() + 1) * numberOfMove);
    }

    private List<Car> createMockCars() {
        Car car1 = new Car();
        car1.setName("pobi");
        Car car2 = new Car();
        car2.setName("crong");
        return Arrays.asList(car1, car2);
    }

    private void printTerminalOutput(List<Car> cars, int numberOfMove) {
        TerminalOutputView.printStartSentence();
        for (int i = 0; i < numberOfMove; i++) {
            cars.forEach(Car::moveRandom);
            TerminalOutputView.printCars(cars);
        }
    }
}

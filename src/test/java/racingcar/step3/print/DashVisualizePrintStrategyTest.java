package racingcar.step3.print;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step3.Car;
import racingcar.step3.move.IncrementMoveStrategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DashVisualizePrintStrategyTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("자동차의 위치를 '-'를 사용해 출력한다.")
    @Test
    void printCarLocationWithDash() {
        // given
        DashVisualizePrintStrategy printStrategy = new DashVisualizePrintStrategy();
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new IncrementMoveStrategy()));

        // when
        cars.get(0).move();
        cars.get(0).move();
        printStrategy.printRoundResult(cars);

        // then
        assertThat(output.toString().trim()).isEqualTo("--");
    }
}
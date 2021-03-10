package racing.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.car.Car;
import racing.dto.RacingReport;
import racing.io.OutputDriver;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    private TestOutputDriver outputDriver;
    private ResultView resultView;

    @BeforeEach
    void init() {
        outputDriver = new TestOutputDriver();
        resultView = new ResultView(outputDriver, "-");
    }

    @Test
    @DisplayName("경주 결과를 출력한다.")
    void printRacingReport() {
        RacingReport report = new RacingReport();

        Car car = new Car(() -> 3, "pobi");

        car.move();
        report.saveRoundResult(Collections.singletonList(car));

        car.move();
        report.saveRoundResult(Collections.singletonList(car));

        report.addWinner(car.getName());

        String expected = "실행 결과\n" +
            "pobi : ---\n" +
            "\n" +
            "pobi : ------\n" +
            "\n" +
            "pobi가 최종 우승했습니다.\n";

        resultView.printRacingReport(report);

        assertThat(outputDriver.getOutput()).isEqualTo(expected);
    }

    private static class TestOutputDriver implements OutputDriver {

        private static final String NEW_LINE = "\n";

        private String output = "";

        @Override
        public void println(String message) {
            output += message + NEW_LINE;
        }

        @Override
        public void print(String message) {
            output += message;
        }

        public String getOutput() {
            return output;
        }
    }

}

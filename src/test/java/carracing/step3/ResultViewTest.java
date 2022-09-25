package carracing.step3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private ResultView resultView;

    @BeforeEach
    void setUp() {
        resultView = new ResultView();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void setDown() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    @DisplayName("자동차 경주 결과 테스트 : 결과 PASS")
    void printResults() {
        final int carCount = 3;
        final int tryCount = 4;
        final Cars cars = new Cars(carCount);

        this.resultView.printResults(tryCount, cars);
        assertThat(output.toString()).contains("-");
    }

}
package step2.racing.ui;

import org.junit.jupiter.api.*;
import step2.racing.dto.RacingResult;
import step2.racing.model.Car;
import step2.racing.random.RandomGenerator;
import step2.racing.random.StubRandomGenerator;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    private ResultView resultView;

    private RandomGenerator moveStubRandomGenerator = new StubRandomGenerator(7);
    private RandomGenerator notMoveStubRandomGenerator = new StubRandomGenerator(2);

    private OutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {

        resultView = new ResultView(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("차량 위치 출력 검증")
    void printEntireCarsPosition() {

        Car car1 = Car.of(0);
        car1.race(7);
        Car car2 = Car.of(1);
        car2.race(2);
        Car car3 = Car.of(2);
        car3.race(4);

        RacingResult racingResult = new RacingResult();
        racingResult.addCarPosition(Arrays.asList(car1, car2, car3));
        resultView.printTotalRaces(racingResult);

        assertThat(byteArrayOutputStream.toString())
                .isEqualTo("\n"
                         + "--\n"
                         + "-\n"
                         + "--\n"
                         + "\n");
    }
}
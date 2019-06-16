package step2.racing.ui;

import org.junit.jupiter.api.*;
import step2.racing.dto.EntireCars;
import step2.racing.dto.RacingResult;
import step2.racing.model.Car;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    private ResultView resultView;

    private OutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {

        resultView = new ResultView(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("차량 위치 출력 검증")
    void printEntireCarsPosition() {

        EntireCars entireCars = EntireCars.createCars(3);
        entireCars.stream()
                .filter(car -> car.getUniqueNumber() % 2 == 1)
                .forEach(car -> car.race(Car.MOVE_THRESHOLD + 1));

        RacingResult racingResult = new RacingResult();
        racingResult.addCurrentCarPosition(entireCars);

        resultView.printRacingResult(racingResult);

        assertThat(byteArrayOutputStream.toString())
                .isEqualTo("\n"
                                   + "--\n"
                                   + "-\n"
                                   + "--\n"
                                   + "\n");
    }
}
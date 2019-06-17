package racing.ui;

import org.junit.jupiter.api.*;
import racing.dto.EntireCars;
import racing.dto.RacingResult;

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

        int shouldMoveNumber = 5;

        EntireCars entireCars = EntireCars.createCars(3);
        entireCars.stream()
                .filter(car -> car.getUniqueNumber() % 2 == 1)
                .forEach(car -> car.race(shouldMoveNumber));

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
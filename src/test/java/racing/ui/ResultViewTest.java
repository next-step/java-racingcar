package racing.ui;

import org.junit.jupiter.api.*;
import racing.dto.EntireCars;
import racing.dto.RacingResult;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    private ResultView resultView;

    private OutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {

        resultView = new ResultView(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("레이싱 결과 출력")
    void printRacingResult() {

        int shouldMoveNumber = 5;

        EntireCars entireCars = EntireCars.createCars(Arrays.asList("pobi", "crong", "honux"));
        IntStream.range(0, 6).forEach( i->
            entireCars.stream().forEach(car -> car.race(shouldMoveNumber)));

        RacingResult racingResult = new RacingResult();
        racingResult.addCurrentRacingPosition(entireCars);

        resultView.printRacingResult(racingResult);

        assertThat(byteArrayOutputStream.toString())
                .isEqualTo("\n"
                         + "crong : -------\n"
                         + "pobi : -------\n"
                         + "honux : -------\n"
                         + "\n"
                         + "crong, pobi, honux가 최종우승 했습니다.");
    }
}
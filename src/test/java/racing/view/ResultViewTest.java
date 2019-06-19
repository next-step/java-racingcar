package racing.view;

import org.junit.jupiter.api.*;
import racing.domain.Car;
import racing.domain.EntireCars;
import racing.dto.RacingResult;
import racing.dto.RacingScore;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    private ResultView resultView;

    private OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private int shouldMove = 5;
    private EntireCars entireCars = EntireCars.of(Arrays.asList("pobi", "crong", "honux"));

    @BeforeEach
    void setUp() {

        resultView = new ResultView(new PrintStream(byteArrayOutputStream));
    }

    @Test
    @DisplayName("공동우승 시 레이싱 결과출력 검증")
    void printRacingResult_multi_winner() {

        testRace(6, Objects::nonNull);
        RacingResult racingResult = RacingResult.initRacingScore(RacingScore.of(entireCars));

        resultView.printResult(racingResult);

        assertThat(byteArrayOutputStream.toString())
                .isEqualTo("pobi : -------\n"
                                   + "crong : -------\n"
                                   + "honux : -------\n"
                                   + "\n"
                                   + "pobi, crong, honux가 최종우승 했습니다.");
    }

    @Test
    @DisplayName("단독우승 시 레이싱 결과출력 검증")
    void printRacingResult() {

        testRace(6, car -> "pobi".equals(car.getName()));
        RacingResult racingResult = RacingResult.initRacingScore(RacingScore.of(entireCars));

        resultView.printResult(racingResult);

        assertThat(byteArrayOutputStream.toString())
                .isEqualTo("pobi : -------\n"
                                   + "crong : -\n"
                                   + "honux : -\n"
                                   + "\n"
                                   + "pobi가 최종우승 했습니다.");
    }

    private void testRace(int raceCount, Predicate<Car> shouldRacePredicate) {

        IntStream.range(0, raceCount).forEach(
                i -> entireCars.getCars()
                        .stream()
                        .filter(shouldRacePredicate)
                        .forEach(car -> car.race(shouldMove)));
    }
}
package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.LapResult;
import racingcar.domain.RaceResults;
import racingcar.Racing;
import racingcar.domain.RandomRacingRule;

public class OutputViewTest {

    private ByteArrayOutputStream outputStream;
    private Racing racing;

    @BeforeEach
    void 시스템_아웃_세팅() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(new Car());
        }
        List<LapResult> lapResults = new ArrayList<>();
        racing = new Racing(new Cars(cars), 10, new RaceResults(lapResults), new RandomRacingRule());
        racing.playFullRace();
    }

    @Test
    void 레이스_결과() {
        OutputView.announceRaceResults(racing.raceResults());
        assertAll(
            () -> assertThat(outputStream.toString()).containsPattern("(.{1,5} : -{1,2}\n){3}\n((.{1,5} : -{1,11}\n){3}\n){9}"),
            () -> assertThat(outputStream.toString()).containsPattern("((.{1,5}),?){1,3}가 최종 우승했습니다.")
        );
    }

}

package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.LapResult;
import racingcar.domain.RaceResults;
import racingcar.domain.RandomRacingRule;


@DisplayName("레이스 테스트")
public class RacingTest {

    private ByteArrayOutputStream outputStream;
    private Racing racing;

    @BeforeEach
    void 시스템_아웃_레이싱_초기화_세팅() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(new Car());
        }
        List<LapResult> lapResults = new ArrayList<>();
        racing = new Racing(new Cars(cars), 10, new RaceResults(lapResults), new RandomRacingRule());
    }

    @Test
    void 레이스_시작() {
        racing.playFullRace();
        List<Car> cars = racing.cars().cars();
        for (Car car : cars) {
            assertThat(car.position()).isBetween(Car.SET_POSITION, Car.SET_POSITION + 10);
        }
    }

    @Test
    void 레이스_세팅() {
        assertAll(
            () -> assertThat(racing.cars().cars()).hasSize(3),
            () -> assertThat(racing.raceCount()).isEqualTo(10),
            () -> assertThat(racing.raceResults()).isNotNull()
        );
    }

}

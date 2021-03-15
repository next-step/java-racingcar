package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @DisplayName("레이싱게임이 아직 끝나지 않음")
    @ParameterizedTest
    @CsvSource(value = "자동차1호,자동차2호:3", delimiter = ':')
    void isFinished(String carNames, int attemptNumber) {
        Racing racing = Racing.of(Cars.of(carNames.split(",")), attemptNumber, new RandomMoveBehavior());
        assertThat(racing.isFinished()).isFalse();
    }

    @DisplayName("레이싱게임 정상 종료")
    @ParameterizedTest
    @CsvSource(value = {"자동차1호,자동차2호:2", "자동차1호,자동차2호,자동차3호:3"}, delimiter = ':')
    void race(String carNames, int attemptNumber) {
        Racing racing = Racing.of(Cars.of(carNames.split(",")), attemptNumber, new RandomMoveBehavior());
        for (int i = 0; i < attemptNumber; i++) {
            racing.race();
        }
        assertThat(racing.isFinished()).isTrue();
    }

    @DisplayName("레이싱게임의 우승자 확인")
    @Test
    void checkWinner() {
        List<Car> carList = new ArrayList<>();
        Car car1 = Car.of("hwang");
        Car car2 = Car.of("lee");
        Car car3 = Car.of("kim");
        car1.move(5);
        car2.move(4);
        car3.move(10);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);

        Racing racing = Racing.of(Cars.of(carList), 5, new RandomMoveBehavior());

        assertThat(racing.getWinners().get(0).getCarName()).isEqualTo("kim");
    }
}

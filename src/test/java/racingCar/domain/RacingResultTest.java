package racingCar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingResultTest {
    private Car car1;
    private Car car2;
    private Car car3;
    private Racing cars;

    @BeforeEach
    void setUp() {
        cars = new Racing("benz,bmw,audi", new TestMoveStrategy());
        cars.race();
    }

    @Test
    @DisplayName("우승자 확인")
    void winnerCheck() {
        RacingResult result = new RacingResult(cars.getRacingCars());
        result.getWinners();
        assertThat(result.toString()).isEqualTo("benz, bmw, audi가 최종 우승했습니다.");
    }
}

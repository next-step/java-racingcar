package step3.collections;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.Car;
import step3.dto.CarWentResult;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    private static final int PARTICIPATION_COUNT = 3;

    private final RacingCars racingCars = new RacingCars(PARTICIPATION_COUNT);

    @DisplayName("참가자 수와 1회 이동을 시도한 결과의 수가 같은가")
    @Test
    void attempt() {
        AttemptResult assertAttemptResult = new AttemptResult(List.of(new CarWentResult(0,0),
                                                                    new CarWentResult(1,0),
                                                                    new CarWentResult(2,0)));
        assertThat(racingCars.attempt()).isEqualTo(assertAttemptResult);

    }

    @DisplayName("참가자 수와 raceCondition 객체 안의 차량 수가 같은가")
    @Test
    void getCarsCount() {
        RacingCars assertRacingCars = new RacingCars(List.of(new Car(0), new Car(1), new Car(2)));
        assertThat(racingCars).isEqualTo(assertRacingCars);
    }

}

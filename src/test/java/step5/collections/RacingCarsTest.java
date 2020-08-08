package step5.collections;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;
import step5.dto.CarWentResult;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    private static final String[] PARTICIPATION_NAMES = new String[]{"0","1","2"};

    private final RacingCars racingCars = RacingCars.fromParticipationNames(PARTICIPATION_NAMES);

    @DisplayName("참가자 수와 1회 이동을 시도한 결과의 수가 같은가")
    @Test
    void attempt() {
        AttemptResult assertAttemptResult = new AttemptResult(List.of(new CarWentResult("0",0),
                                                                    new CarWentResult("1",0),
                                                                    new CarWentResult("2",0)));
        assertThat(racingCars.attempt()).isEqualTo(assertAttemptResult);

    }

    @DisplayName("참가자 수와 RacingCars 객체 안의 차량 수가 같은가")
    @Test
    void getCarsCount() {
        RacingCars assertRacingCars = RacingCars.fromCars(List.of(new Car("0"), new Car("1"), new Car("2")));
        assertThat(racingCars).isEqualTo(assertRacingCars);
    }

}

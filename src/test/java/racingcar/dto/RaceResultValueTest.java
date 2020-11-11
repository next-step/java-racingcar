package racingcar.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Motor;
import racingcar.model.TesterMotor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RaceResultValueTest {

    private static final int TRY_COUNT = 3;

    private Motor motor;
    List<StepResult> stepResults = new ArrayList<>();

    @BeforeEach
    void setup() {
        motor = new TesterMotor();

        Car car1 = new Car("dong", motor);
        Car car2 = new Car("woong", motor);
        Car car3 = new Car("hwi", motor);

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        // car1 : 1,1,2
        // car2 : 0,1,1
        // car3 : 1,2,3

        car1.move();
        car3.move();

        StepResult stepResult1 = StepResult.of(cars);

        car2.move();
        car3.move();

        StepResult stepResult2 = StepResult.of(cars);

        car1.move();
        car3.move();

        StepResult stepResult3 = StepResult.of(cars);

        stepResults.add(stepResult1);
        stepResults.add(stepResult2);
        stepResults.add(stepResult3);
    }

    @DisplayName("RaceResultValue() 생성자 테스트")
    @Test
    void RaceResultValue1() {
        RaceResultValue raceResultValue = RaceResultValue.of(TRY_COUNT, stepResults);

        assertThat(raceResultValue)
                .isEqualToComparingFieldByField(raceResultValue);
    }

    @DisplayName("RaceResultValue() 생성자 테스트 : 실패케이스 -> 시도 횟수와 자동차경주 횟수가 일치하지 않는 경우 에러")
    @Test
    void RaceResultValue2() {
        int tryCount = 2;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            RaceResultValue.of(tryCount, stepResults);
        });
    }

    @DisplayName("getWinnerName() 테스트 : 우승자 확인")
    @Test
    void getWinnerName() {
        RaceResultValue raceResultValue = RaceResultValue.of(TRY_COUNT, stepResults);

        assertThat(raceResultValue.getFinalWinnerName().size()).isEqualTo(1);
        assertThat(raceResultValue.getFinalWinnerName()).contains("hwi");
    }
}

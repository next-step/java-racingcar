package racingcar.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Motor;
import racingcar.model.TesterMotor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RaceResultValueTest {

    private static final int TRY_COUNT = 3;

    private Motor motor;
    List<StepByCar> stepByCars;

    @BeforeEach
    void setup() {
        motor = new TesterMotor();

        // car1 : 1,1,2
        // car2 : 0,1,1
        // car3 : 1,2,3

        Car car1 = new Car("dong", motor);
        Car car2 = new Car("woong", motor);
        Car car3 = new Car("hwi", motor);

        car1.move();
        car3.move();

        List<StepByCar> step1 = Arrays.asList(
                StepByCar.of(car1),
                StepByCar.of(car2),
                StepByCar.of(car3));

        car2.move();
        car3.move();

        List<StepByCar> step2 = Arrays.asList(
                StepByCar.of(car1),
                StepByCar.of(car2),
                StepByCar.of(car3));

        car1.move();
        car3.move();

        List<StepByCar> step3 = Arrays.asList(
                StepByCar.of(car1),
                StepByCar.of(car2),
                StepByCar.of(car3));

        stepByCars = new ArrayList<>();
        stepByCars.addAll(step1);
        stepByCars.addAll(step2);
        stepByCars.addAll(step3);
    }

    @DisplayName("RaceResultValue() 생성자 테스트")
    @Test
    void RaceResultValue1() {
        Car car1 = new Car("belle", motor);
        Car car2 = new Car("jin", motor);
        int tryCount = 2;

        List<StepByCar> stepByCarList = Arrays.asList(
                StepByCar.of(car1),
                StepByCar.of(car1),
                StepByCar.of(car2),
                StepByCar.of(car2));

        assertThat(RaceResultValue.of(tryCount, stepByCarList))
                .isEqualToComparingFieldByField(RaceResultValue.of(tryCount, stepByCarList));
    }

    @DisplayName("RaceResultValue() 생성자 테스트 : 실패케이스 -> 시도 횟수와 자동차경주 횟수가 일치하지 않는 경우 에러")
    @Test
    void RaceResultValue2() {
        Car car1 = new Car("belle", motor);
        Car car2 = new Car("jin", motor);
        int tryCount = 2;

        List<StepByCar> stepByCarList = Arrays.asList(
                StepByCar.of(car1),
                StepByCar.of(car2));

        assertThatIllegalArgumentException().isThrownBy(() -> {
            RaceResultValue.of(tryCount, stepByCarList);
        });
    }

    @DisplayName("getMaxScore() 테스트 : 경주 MaxScore 확인")
    @Test
    void getMaxScore() {
        RaceResultValue raceResultValue = RaceResultValue.of(TRY_COUNT, stepByCars);

        assertThat(raceResultValue.getMaxScore()).isEqualTo(3);
    }

    @DisplayName("RaceResultValue() 테스트 : 우승자 확인")
    @Test
    void getWinnerName() {
        RaceResultValue raceResultValue = RaceResultValue.of(TRY_COUNT, stepByCars);

        assertThat(raceResultValue.getWinnerName().size()).isEqualTo(1);
        assertThat(raceResultValue.getWinnerName()).contains("hwi");
    }
}

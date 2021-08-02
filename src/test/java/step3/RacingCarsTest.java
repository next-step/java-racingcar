package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    private int cars;

    @BeforeEach
    public void setup() {
        cars = 4;
    }

    @Test
    @DisplayName("자동차 대수를 입력받아 초기화하면 입력만큼 자동차들이 만들어진다")
    public void 자동차_대수를_입력받아_초기화하면_입력만큼_자동차들이_만들어진다() {
        //given
        //when
        RacingCars racingCars = RacingCars.create(cars);
        //then
        assertThat(racingCars.size()).isEqualTo(cars);
    }

    /**
     * 랜덤한 값을 가지기 때문에 늘 테스트 통과를 보장할 수 없다
     */
    @Disabled
    @Test
    @DisplayName("1회 실행한 후 자동차의 상태값이 기존과 다른지 확인한다")
    public void _1회_실행한_후_자동차의_상태값이_기존과_다른지_확인한다() {
        //given
        RacingCars racingCars = RacingCars.create(cars);
        String beforeRunningRacingCarsStatus = CarsStatusHelper.getCarsStatusView(racingCars);
        //when
        racingCars.run();
        //then
        assertThat(CarsStatusHelper.getCarsStatusView(racingCars)).isNotEqualTo(beforeRunningRacingCarsStatus);
    }
}

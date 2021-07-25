package racingcar.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.entity.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    private RacingCar racingCar;
    public static final int tryNumber = 5;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @Test
    @DisplayName("레이싱 카 생성 후 시작 위치는 0임을 확인한다.")
    void basePosition(){
        assertThat(racingCar.getPosition()).isEqualTo(RacingCar.BASE_POSITION);
    }

}
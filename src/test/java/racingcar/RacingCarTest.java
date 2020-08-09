package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingCarTest {
    private static final int ATTEMPT_NUMBER = 4;
    private static final int ATTEMPT_NUMBER_ZERO = 0;

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
        racingCar.setCarMover(new RandomNumberMover());
    }

    @DisplayName("race 메소드 실행 전 테스트")
    @Test
    void race_before_test() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> racingCar.getRaceRecord().getBy(0));
    }

    @DisplayName("race 메소드 실행 후 테스트")
    @Test
    void race_after_test() {
        racingCar.race(ATTEMPT_NUMBER);

        // racingCar의 raceRecord 생성 여부 확인
        assertThat(racingCar.getRaceRecord()).isNotNull();
        // racingCar의 raceRecord가 마지막 attempt까지 잘 생성되었는지 확인
        assertThat(racingCar.getRaceRecord().getBy(ATTEMPT_NUMBER - 1)).isNotNull();
    }

    @DisplayName("race 메소드 - raceRecord 생성 테스트")
    @Test
    void race_test() {
        racingCar.race(ATTEMPT_NUMBER_ZERO);

        // racingCar의 raceRecord가 빈 리스트로 생성되었는지 확인
        assertThat(racingCar.getRaceRecord()).isNotNull();
        // racingCar의 raceRecord가
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> racingCar.getRaceRecord().getBy(ATTEMPT_NUMBER_ZERO))
                .withMessageMatching("Index: \\d+, Size: \\d+");
    }
}
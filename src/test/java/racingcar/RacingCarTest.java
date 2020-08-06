package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingCarTest {
    private static final int ATTEMPT_NUMBER = 4;
    private static Random random;

    @BeforeAll
    static void setUp() {
        random = new Random();
    }

    @DisplayName("race 메소드 실행 전 테스트")
    @Test
    void race_before_test() {
        RacingCar racingCar = RacingCar.create(random);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> racingCar.getRaceRecord().getBy(0))
                .withMessageMatching("Index: \\d+, Size: \\d+");
    }

    @DisplayName("race 메소드 실행 후 테스트")
    @Test
    void race_after_test() {
        RacingCar racingCar = RacingCar.create(random);

        racingCar.race(ATTEMPT_NUMBER);

        // racingCar의 raceRecord 생성 여부 확인
        assertThat(racingCar.getRaceRecord()).isNotNull();
        // racingCar의 raceRecord가 마지막 attempt까지 잘 생성되었는지 확인
        assertThat(racingCar.getRaceRecord().getBy(ATTEMPT_NUMBER - 1)).isNotNull();
    }
}
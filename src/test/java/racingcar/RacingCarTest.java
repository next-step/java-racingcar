package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RacingCarTest {
    private static final int ATTEMPT_NUMBER = 4;
    private static final int ATTEMPT_NUMBER_ZERO = 0;
    private static final String NAME = "happy";
    private static final CarMover RANDOM_NUMBER_CAR_MOVER = new RandomNumberMover();
    private static final CarMover ALWAYS_MOVE_CAR_MOVER = new AlwaysMoveCarMover();
    private static final CarMover REPEATING_CAR_MOVER = new RepeatingCarMover();

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = RacingCar.create(NAME);
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
        racingCar.race(ATTEMPT_NUMBER, ALWAYS_MOVE_CAR_MOVER);

        // racingCar의 raceRecord 생성 여부 확인
        assertThat(racingCar.getRaceRecord()).isNotNull();
        // racingCar의 raceRecord가 마지막 attempt까지 잘 생성되었는지 확인
        assertThat(racingCar.getRaceRecord().getBy(ATTEMPT_NUMBER - 1)).isNotNull();
    }

    @DisplayName("race 메소드 - raceRecord 생성 테스트")
    @Test
    void race_test() {
        racingCar.race(ATTEMPT_NUMBER_ZERO, ALWAYS_MOVE_CAR_MOVER);

        // racingCar의 raceRecord가 빈 리스트로 생성되었는지 확인
        assertThat(racingCar.getRaceRecord()).isNotNull();
        // racingCar의 raceRecord가
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> racingCar.getRaceRecord().getBy(ATTEMPT_NUMBER_ZERO))
                .withMessageMatching("Index: \\d+, Size: \\d+");
    }

    @DisplayName("checkNameValidation 유효한 car 이름 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"DD", "LALA", "MOMO", "ab12"})
    void checkNameValidation_valid_test(String name) {
        assertThatCode(() -> RacingCar.checkNameValidation(name))
                .doesNotThrowAnyException();
    }

    @DisplayName("checkNameValidation 유효하지 않은 car 이름 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", "DUNDUN", "1234567890"})
    void checkNameValidation_invalid_test(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> RacingCar.checkNameValidation(name))
                .withMessageContaining("자동차 이름은 ");
    }
}
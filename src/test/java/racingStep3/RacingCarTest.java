package racingStep3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingStep3.domain.Position;
import racingStep3.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class RacingCarTest {

    private static RacingCar testCar;

    @BeforeEach
    void setUp() {
        testCar = RacingCar.create();
    }

    @ParameterizedTest
    @DisplayName("값이 정상적인 경우")
    @ValueSource(ints = {3,5,7})
    void create(int location) {
        Position position = Position.create(location);
        assertThat(position).isEqualTo(Position.create(location));
    }

    @Test
    @DisplayName("Null check")
    void nullcheck() {

        assertThatNullPointerException().isThrownBy(() -> new RacingCar(null));
    }

    @Test
    @DisplayName("조건이 맞는 경우 위치 증가 검증")
    void increaseLocation() {

        for(int i = 1; i< 10; i++) {
            testCar.decisionMove(true);
            assertThat(testCar.getLocation()).isEqualTo(i);
        }
    }

    @Test
    @DisplayName("조건이 아닌 경우 위치 정지 검증")
    void stopLocation() {

        for(int i = 0; i < 10; i++) {
            testCar.decisionMove(false);
            assertThat(testCar.getLocation()).isEqualTo(0);
        }
    }
}

package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.value.Position;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class RacingCarTest {

    private static RacingCar testCar;

    @BeforeEach
    void setUp() {
        testCar = RacingCar.create("test");
    }

    @ParameterizedTest
    @DisplayName("값이 정상적인 경우")
    @ValueSource(ints = {3,5,7})
    void createTest(int location) {
        Position position = Position.create(location);
        assertThat(position).isEqualTo(Position.create(location));
    }

    @Test
    @DisplayName("Null check")
    void nullcheckTest() {

        assertThatNullPointerException().isThrownBy(() -> new RacingCar(null, null));
    }

    @Test
    @DisplayName("조건이 맞는 경우 위치 증가 검증")
    void increaseLocationTest() {

        testCar.decisionMove(true);
        assertThat(testCar.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("조건이 아닌 경우 위치 정지 검증")
    void stopLocationTest() {

        testCar.decisionMove(false);
        assertThat(testCar.getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름을 입력했을 경우 자동차에 잘 입력되는지 확인")
    void setCarNameTest() {
        assertThat(testCar.getCarName().getName()).isEqualTo("test");
    }
}

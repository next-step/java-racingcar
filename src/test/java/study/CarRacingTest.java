package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * <pre>
 * * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 * </pre>
 */
public class CarRacingTest {
    @Test
    @DisplayName("자동차 경주 객체를 생성할 수 있다.")
    void instantiation() {
        assertThatCode(CarRacing::new).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 경주 객체는 경주정보 제공자를 입력받는다.")
    void instantiationWithProvider() {
        assertThatCode(() -> {
            new CarRacing(new RacingInfoProvider() {
            });
        }).doesNotThrowAnyException();
    }

    private static class CarRacing {
        public CarRacing(RacingInfoProvider racingInfoProvider) {

        }

        public CarRacing() {
            this(null);
        }
    }

    private interface RacingInfoProvider {

    }
}

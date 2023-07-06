package racingcar;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    void 각_자동차에_이름을_부여할_수_있다() {
        String name = "chanu";

        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과이면 에러를 던진다")
    void 자동차_이름이_5자_초과이면_에러를_던진다() {
        String name = "failfail";

        ThrowableAssert.ThrowingCallable callable = () -> new Car(name);

        assertThatThrownBy(callable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5글자 이하여야 합니다");
    }

    @Test
    @DisplayName("차가 전진한다")
    void 차가_전진한다() {
        Car car = new Car("hello");

        car.forward();

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("0에서 9 사이의 랜덤한 숫자를 반환한다")
    void 영에서_9_사이의_랜덤한_숫자를_반환한다() {

        int number = RandomGenerator.generateNumber();
        assertThat(number).isBetween(0, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 값이 4 이상일 경우 전진한다")
    void 랜덤_값이_4_이상일_경우_전진한다(int number) {
        Car car = new Car("chan");

        car.progress(number);

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤 값이 3 이하일 경우 멈춘다.")
    void 랜덤_값이_3_이하일_경우_멈춘다(int number) {
        Car car = new Car("chan");

        car.progress(number);

        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 여러 자동차들 중 가장 멀리 있는 자동차인지 테스트")
    void 자동차가_여러_자동차들_중_가장_멀리_있는_자동차인지_테스트() {
        Car itp = new Car("itp");
        Car pobi = new Car("pobi");

        int moveSignal = 5;
        int maxDistance = 5;
        for (int i = 0; i < maxDistance; i++) itp.progress(moveSignal);

        assertThat(itp.isMaxDistance(maxDistance)).isEqualTo(true);
        assertThat(pobi.isMaxDistance(maxDistance)).isEqualTo(false);
    }
}

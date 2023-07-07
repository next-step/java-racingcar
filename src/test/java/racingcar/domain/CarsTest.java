package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("자동차들 중 가장 멀리 간 차들의 이름을 반환한다.")
    void 자동차들_중_가장_멀리_간_차들의_이름을_반환한다() {
        Car chanCar = new Car("chan");
        Car iptCar = new Car("ipt");
        Car tommyCar = new Car("tommy");
        chanCar.forward();
        iptCar.forward();

        Cars cars = new Cars(List.of(chanCar, iptCar, tommyCar));

        List<String> winnerNames = cars.findWinnerNames();
        assertThat(winnerNames.size()).isEqualTo(2);
        assertThat(winnerNames).containsAnyOf(chanCar.getName(), iptCar.getName());
    }

    @Test
    @DisplayName("자동차들_중_가장_멀리_간_차들의_이름을_반환한다_다른_거리")
    void 자동차들_중_가장_멀리_간_차들의_이름을_반환한다_다른_거리() {
        Car chanCar = new Car("chan");
        Car iptCar = new Car("ipt");
        Car tommyCar = new Car("tommy");
        chanCar.forward();
        chanCar.forward();
        iptCar.forward();
        Cars cars = new Cars(List.of(chanCar, iptCar, tommyCar));

        List<String> winnerNames = cars.findWinnerNames();

        assertThat(winnerNames.size()).isEqualTo(1);
        assertThat(winnerNames).containsAnyOf(chanCar.getName());
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있으면 예외가 발생합니다.")
    void 자동차_이름에_중복이_있으면_예외가_발생합니다() {
        assertThatThrownBy(() -> new Cars(
                List.of(new Car("pobi"),
                        new Car("ipt"),
                        new Car("ipt"))))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("자동차 이름에 중복이 있습니다.");
    }

    @Test
    @DisplayName("자동차 이름에 중복이 없고 모두 5글자 이하라면 정상적으로 생성합니다")
    void 자동차_이름에_중복이_없고_모두_5글자_이하라면_정상적으로_생성합니다() {
        Assertions.assertThatCode(() -> new Cars(
                        List.of(new Car("pobi"),
                                new Car("ipt"),
                                new Car("neo"))))
                .doesNotThrowAnyException();
    }
}

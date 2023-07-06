package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차들 중 가장 멀리 간 차들의 이름을 반환한다.")
    public void 자동차들_중_가장_멀리_간_차들의_이름을_반환한다() throws Exception {
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
    public void 자동차들_중_가장_멀리_간_차들의_이름을_반환한다_다른_거리() throws Exception {
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
    @DisplayName("자동차 이름이 같으면 동일한 Car로 판단한다")
    public void 자동차_이름이_같으면_동일한_Car로_판단한다() throws Exception {
        Cars cars = Cars.from(List.of("ipt", "ipt"));

        List<Car> car = cars.getCars();

        Assertions.assertThat(car.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 없다면 IllegalStateException 예외를 던진다.")
    public void 자동차가_없다면_IllegalStateException_예외를_던진다() throws Exception {
        Cars cars = Cars.from(List.of());

        Assertions.assertThatThrownBy(cars::findWinnerNames)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Car 객체를 찾을 수 없습니다.");
    }
}

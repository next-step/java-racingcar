package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("가장 멀리간 자동차들을 가져온다. ")
    public void 가장_멀리간_차를_가져온다() throws Exception {
        Car furtherCar = new Car("chan", 2);
        Car otherFurtherCar = new Car("ipt", 2);
        Cars cars = new Cars(List.of(furtherCar, otherFurtherCar, new Car("tommi", 1)));
        List<Car> maxDistanceCars = cars.getMaxDistanceCars();

        assertThat(maxDistanceCars).contains(furtherCar, otherFurtherCar);

    }

    @Test
    @DisplayName("자동차들 중 가장 멀리 간 차들의 이름을 반환한다.")
    public void 자동차들_중_가장_멀리_간_차들의_이름을_반환한다() throws Exception {
        Car chanCar = new Car("chan", 4);
        Car iptCar = new Car("ipt", 4);
        Car tommyCar = new Car("tommy", 1);

        Cars cars = new Cars(List.of(chanCar, iptCar, tommyCar));

        List<String> winnerNames = cars.findWinnerNames();
        assertThat(winnerNames.size()).isEqualTo(2);
        assertThat(winnerNames).containsAnyOf(chanCar.getName(), iptCar.getName());
    }

    @Test
    @DisplayName("자동차들_중_가장_멀리_간_차들의_이름을_반환한다_다른_거리")
    public void 자동차들_중_가장_멀리_간_차들의_이름을_반환한다_다른_거리() throws Exception {
        Car chanCar = new Car("chan", 1);
        Car iptCar = new Car("ipt", 0);
        Car tommyCar = new Car("tommy", 0);
        Cars cars = new Cars(List.of(chanCar, iptCar, tommyCar));

        List<String> winnerNames = cars.findWinnerNames();

        assertThat(winnerNames.size()).isEqualTo(1);
        assertThat(winnerNames).containsAnyOf(chanCar.getName());
    }

}

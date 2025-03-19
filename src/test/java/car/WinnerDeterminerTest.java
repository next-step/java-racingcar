package car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.FixedNumberGenerator;
import utils.NumberGenerator;

import java.util.List;


class WinnerDeterminerTest {

    @Test
    @DisplayName("단독 우승자가 정상적으로 판별되어야 한다")
    void 우승자_판별() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");

        Cars cars = new Cars(List.of(car1, car2, car3));

        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(4);
        car1.move(fixedNumberGenerator);
        car1.move(fixedNumberGenerator);

        Assertions.assertThat(WinnerDeterminer.findWinners(cars)).isEqualTo(List.of(car1));
    }

    @Test
    @DisplayName("공동 우승자가 있을 경우, 모두 우승자로 판별되어야 한다")
    void 공동_우승자_판별() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");

        Cars cars = new Cars(List.of(car1, car2, car3));

        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator(4);
        car1.move(fixedNumberGenerator);
        car2.move(fixedNumberGenerator);

        Assertions.assertThat(WinnerDeterminer.findWinners(cars)).isEqualTo(List.of(car1, car2));
    }
}
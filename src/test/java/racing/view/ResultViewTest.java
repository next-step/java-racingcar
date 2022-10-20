package racing.view;

import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    @Test
    void 자동차_패턴() {
        Car car1 = new Car("자동차1");
        Car car2 = new Car("자동차2", 1);
        Car car3 = new Car("자동차3", 3);

        assertThat(new ResultView().printCarPosition(car1)).isEqualTo("");
        assertThat(new ResultView().printCarPosition(car2)).isEqualTo("-");
        assertThat(new ResultView().printCarPosition(car3)).isEqualTo("---");
    }

    @Test
    void 자동차명_패턴() {
        Car car1 = new Car("자동차1");
        Car car2 = new Car("자동차2", 1);
        Car car3 = new Car("자동차3", 3);

        assertThat(new ResultView().printCarPosition(car1)).isEqualTo("자동차1 : ");
        assertThat(new ResultView().printCarPosition(car2)).isEqualTo("자동차2 : -");
        assertThat(new ResultView().printCarPosition(car3)).isEqualTo("자동차3 : ---");
    }
}
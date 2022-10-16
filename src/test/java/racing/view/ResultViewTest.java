package racing.view;

import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    @Test
    void 패턴_반복() {
        assertThat(ResultView.positionStatus(2)).isEqualTo("--");
    }

    @Test
    void GO_출력() {
        Car car = new Car();
        car.move(1);
        assertThat(ResultView.positionStatus(car.getPosition())).isEqualTo("-");
    }

    @Test
    void STOP_출력() {
        Car car = new Car();
        car.move(0);
        assertThat(ResultView.positionStatus(car.getPosition())).isEqualTo("");
    }

    @Test
    void 여러번_이동_출력() {
        Car car = new Car();
        car.move(0);
        car.move(1);
        car.move(1);
        assertThat(ResultView.positionStatus(car.getPosition())).isEqualTo("--");
    }
}
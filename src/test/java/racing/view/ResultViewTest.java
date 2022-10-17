package racing.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewTest {

    private Car car;
    @BeforeEach
    void beforeEach() {
        car = new Car("자동차1");
    }

    @Test
    void 자동차명_패턴() {
        assertThat(ResultView.printCarPosition(car)).isEqualTo("자동차1 : ");
    }

    @Test
    void 패턴_반복() {
        assertThat(ResultView.positionStatus(2)).isEqualTo("--");
    }

    @Nested
    class MovePattern {
        @Test
        void go_출력() {
            car.move(1);
            assertThat(ResultView.positionStatus(car.getPosition())).isEqualTo("-");
        }

        @Test
        void go_이름_출력() {
            car.move(1);
            assertThat(ResultView.printCarPosition(car)).isEqualTo("자동차1 : -");
        }

        @Test
        void stop_출력() {
            car.move(0);
            assertThat(ResultView.positionStatus(car.getPosition())).isEqualTo("");
        }

        @Test
        void 여러번_이동_출력() {
            car.move(0);
            car.move(1);
            car.move(1);
            assertThat(ResultView.positionStatus(car.getPosition())).isEqualTo("--");
        }
    }

}
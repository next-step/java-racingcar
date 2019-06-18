package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car = new Car();

    @Test
    void 자동차가_생성된다() {
        assertThat(car).isNotNull();
    }

    @Test
    void 생성된_자동차의_시작포지션은_0이다() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차는_랜덤숫자가_4이상인_경우만_이동한다() {

        // RaceExecutor 리팩토링 후 작성 예정
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 자동차가_주어진_거리만큼_이동한다(int numberOfMoves) {
        for (int i = 0; i < numberOfMoves; i++) {
            car.move();
        }
        assertThat(car.getPosition()).isEqualTo(numberOfMoves);
    }
}

package racing_game;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @Before
    public void setup() {
        this.car = new Car(null);
    }

    @Test
    public void 이동테스트_이동가능() {
        final int goNumber = 4;
        int beforeMoveCount = car.getMoveCount();

        car.move(goNumber);

        assertThat(car.getMoveCount()).isEqualTo(beforeMoveCount + 1);
    }

    @Test
    public void 이동테스트_이동불가() {
        final int notGoNumber = 3;
        int beforeMoveCount = car.getMoveCount();

        car.move(notGoNumber);

        assertThat(car.getMoveCount()).isEqualTo(beforeMoveCount);
    }

}
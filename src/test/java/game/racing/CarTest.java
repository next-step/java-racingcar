package game.racing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    private Car car;

    @Before
    public void setup() {
        this.car = new Car("test");
    }

    @Test
    public void testMove_자동차_움직일때() {
        final int moveNumber = 4;
        final int before = car.getMoveCount();

        car.move(moveNumber);

        int after = car.getMoveCount();
        assertThat(after).isEqualTo(before + 1);
    }

    @Test
    public void testMove_자동차_움직이지_않을때() {
        final int moveNumber = 3;
        final int before = car.getMoveCount();

        car.move(moveNumber);

        int after = car.getMoveCount();
        assertThat(after).isEqualTo(before);
    }

    @Test
    public void 현재상태확인() {
        String currentState = car.getCurrentState();

        assertThat(currentState).isEqualTo("test : -");
    }

    @Test
    public void testIsSameMoveCount() {
        final int initMoveCount = 1;
        assertThat(car.isSameMoveCount(initMoveCount)).isTrue();
    }

    @Test
    public void testMaxMoveCount_현재상태가_최대값일때() {
        final int inputMaxMoveCount = 0;

        int max = car.maxMoveCount(inputMaxMoveCount);

        assertThat(max).isEqualTo(car.getMoveCount());
    }

    @Test
    public void testMaxMoveCount_현재상태가_최대값이_아닐때() {
        final int inputMaxMoveCount = 2;

        int max = car.maxMoveCount(inputMaxMoveCount);

        assertThat(max).isEqualTo(inputMaxMoveCount);
    }

}
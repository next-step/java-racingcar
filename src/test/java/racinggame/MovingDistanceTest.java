package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MovingDistanceTest {

    @Test
    void 이동거리를_생성하면_처음_거리는_0이다() {
        MovingDistance actual = new MovingDistance();
        MovingDistance expected = new MovingDistance(0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 이동거리를_증가_시킬_수_있다() {
        MovingDistance actual = new MovingDistance();
        actual.add();
        MovingDistance expected = new MovingDistance(1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 이동거리를_확인_할_수_있다() {
        MovingDistance movingDistance = new MovingDistance();
        int actual = movingDistance.distance();
        int expected = 0;

        assertThat(actual).isEqualTo(expected);
    }

}

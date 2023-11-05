package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DistanceTest {

    @Test
    void 이동거리를_생성하면_처음_거리는_0이다() {
        Distance actual = new Distance();
        Distance expected = new Distance(0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 이동거리를_증가_시킬_수_있다() {
        Distance actual = new Distance();

        actual.add();

        Distance expected = new Distance(1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 이동거리를_확인_할_수_있다() {
        Distance distance = new Distance();

        int actual = distance.distance();
        int expected = 0;

        assertThat(actual).isEqualTo(expected);
    }

}

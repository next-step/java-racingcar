package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarResultTest {

    @Test
    void 가장_멀리간_자동차일_때_true를_반환한다() {
        Position maxPosition = new Position(3);
        CarResult carResult = new CarResult("자동차", 3);

        assertThat(carResult.isMaxPosition(maxPosition)).isTrue();
    }

    @Test
    void 가장_멀리간_자동차가_아니라면_false를_반환한다() {
        Position maxPosition = new Position(3);
        CarResult carResult = new CarResult("자동차", 1);

        assertThat(carResult.isMaxPosition(maxPosition)).isFalse();
    }
}

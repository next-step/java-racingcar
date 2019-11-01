package winner.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 21:38
 */
public class CarPositionTest {

    @Test
    void position_객체_생성() {
        CarPosition position = new CarPosition();
        assertThat(position).isEqualTo(new CarPosition());
    }

    @Test
    void position_객체_이동() {
        CarPosition position = new CarPosition();
        position.move();
        assertThat(position).isEqualTo(new CarPosition());
    }
}

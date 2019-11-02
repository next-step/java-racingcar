package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.Dao.RacingData;
import step2.Model.DefaultMove;
import step2.Model.Racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingTest {

    Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing(new RacingData(new String[]{"car1", "car2", "car3"}, 5),
                new DefaultMove());
    }

    @Test
    void moveTest() {
        assertAll(
                () -> assertThat(racing.move(1, 0)).isEqualTo("-"),
                () -> assertThat(racing.move(1, 1)).isEqualTo("--"),
                () -> assertThat(racing.move(1, 2)).isEqualTo("---"),
                () -> assertThat(racing.move(1, 3)).isEqualTo("----"),
                () -> assertThat(racing.move(1, 4)).isEqualTo("-----")
        );
    }

}
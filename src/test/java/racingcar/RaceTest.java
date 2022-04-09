package racingcar;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RaceTest {
    @Test
    @Order(1)
    void 자동차_대수가_0대일때() throws InterruptedException {
        assertThatThrownBy(() -> Race.start(0, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Order(2)
    void 경주횟수가_0번일때() throws InterruptedException {
        assertThatThrownBy(() -> Race.start(1, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
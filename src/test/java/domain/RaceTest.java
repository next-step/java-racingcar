package domain;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import service.Race;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RaceTest {
    @Test
    @Order(1)
    void 자동차_대수는_1대_이상이어야_한다() {
        assertThatThrownBy(() -> new Race().start("", new RunRace(1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
package study.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("move 전략 excpetion 테스트")
    @Test
    void move() {
        Cars cars = new Cars(new String[]{"a", "b", "c"});

        assertThatThrownBy(() -> {
            cars.move(null);
        }).isInstanceOf(NullPointerException.class)
                .hasMessage("move 전략이 null 입니다");
    }
}
package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("차량 생성 테스트")
    public void createCarTest() {
        Car pobi = new Car("pobi");
        Car brown = new Car("brown");
        assertAll(
            () -> assertThat(pobi.equals(new Car("pobi"))),
            () -> assertThat(brown.compareTo(brown)).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("차량 생성 테스트 2 - 위치 비교")
    public void createCarTest2() {
        Car pobi = new Car("pobi", new Position(5));
        Car brown = new Car("brown", new Position(4));
        Car honux = new Car("honux", new Position(6));
        assertAll(
            () -> assertThat(pobi.compareTo(brown)).isEqualTo(1),
            () -> assertThat(pobi.compareTo(honux)).isEqualTo(-1)
        );
    }
}

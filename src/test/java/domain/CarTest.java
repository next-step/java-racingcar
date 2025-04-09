package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("차량 생성 테스트")
    public void createCarTest() {
        Car pobi = new Car("pobi");
        Car brown = new Car("brown");
        Assertions.assertAll(
            () -> assertThat(pobi.equals(new Car("pobi"))),
            () -> assertThat(brown.compareTo(brown)).isEqualTo(0)
        );
    }
}

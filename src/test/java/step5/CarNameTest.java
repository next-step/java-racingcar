package step5;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;

public class CarNameTest {

    Car car1;
    Car car2;
    @BeforeEach
    public void before() {
        car1 = new Car("poby", 2);
        car2 = new Car("pobyss", 2);
    }

    @DisplayName("5글자 초과")
    @Test
    void 이상() {
        assertThat(car2.isExceedWord()).isEqualTo(true);
    }

    @DisplayName("5글자 미만")
    @Test
    void 미만() {
        assertThat(car1.isExceedWord()).isEqualTo(false);
    }
}

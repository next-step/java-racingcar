package study;

import com.step3.model.car.Car;
import com.step3.model.car.Cars;
import com.step3.model.car.Name;
import com.step3.model.car.Position;
import com.step3.model.car.strategy.CarMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class NameTest {
    @Test
    @DisplayName("Name class 생성자 test")
    void create() {
        Name name = new Name("haeun");
        assertThat(name.equals(new Name("test"))).isFalse();
        assertThat(name.equals(new Name("haeun"))).isTrue();
    }

    @Test
    @DisplayName("자동차 이름 5자 이상 예외처리 test")
    void get() {
        assertThatThrownBy(() -> new Name("testtest"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 5자 이하 필수");
    }
}

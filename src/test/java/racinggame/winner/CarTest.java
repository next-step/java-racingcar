package racinggame.winner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    void 자동차_이름() {
        assertThatCode(() -> new Car("test1"))
            .doesNotThrowAnyException();
        assertThatThrownBy(() -> new Car("test123"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 전진하는 조건은 0~9 사이의 랜덤 값이 4 이상일 때이다.")
    void 자동차_전진() {
        int initialPos = 1;
        Car sut = new Car("test1", initialPos);
        sut.move(3);
        assertThat(sut.getPosition()).isEqualTo(initialPos);
        sut.move(4);
        assertThat(sut.getPosition()).isEqualTo(initialPos + 1);
    }
}

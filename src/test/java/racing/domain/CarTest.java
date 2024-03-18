package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("전진 하는 경우")
    void 앞으로_전진() {
        Car car = new Car("park");
        car.forward(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("전진 하지 못하는 경우")
    void 정지() {
        Car car = new Car("park");
        car.forward(() -> false);
        assertThat(car.getPosition()).isZero();
    }

    @Test
    @DisplayName("실패: 이름이 없을 경우")
    void 이름_미입력_에러() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름을 입력하세요");
    }

    @Test
    @DisplayName("실패: 이름이 다섯글자를 넘길경우")
    void 이름_다섯_글자_이상이면_에러() {
        assertThatThrownBy(() -> new Car("parkkkkk"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름의 길이는 5자를 초과 할 수 없습니다.");
    }
}